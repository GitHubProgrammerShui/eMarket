package com.emarket.admin.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.Brand;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Type;
import com.eMarket.model.vo.Result;
import com.emarket.admin.service.GoodsManageService;
import com.emarket.dao.BrandDAO;
import com.emarket.dao.GoodsDAO;
import com.emarket.dao.TypeDAO;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.LongPrimaryKeyGenerator;

/**
 * 商品管理实现类
 * @author 水保勤
 *
 */
@Service("goodsManageService")
public class GoodsManageServiceImpl implements GoodsManageService{
	
	@Autowired
	private BrandDAO brandDAO;
	@Autowired
	private TypeDAO typeDAO;
	@Autowired
	private GoodsDAO goodsDAO;
	@Autowired
	private FTPClient ftpClient;
	
	private LengthPrimaryKeyGenerator<Long> generator=new LongPrimaryKeyGenerator();
	
	/**
	 * 初始服务，用于跳转到添加或修改商品页面时需要从数据库中获取品牌和类型数据的情况
	 * @param id 添加商品时使用此方法请传入null，修改商品时使用此方法请传入需要修改的商品id
	 * @return 从数据库中查询出来的数据，其中包括：<br>
	 * 1，所有的品牌列表brandList
	 * 2，所有的类型列表typeList
	 * 3，若传入的id，则存在数据库中该id所指的商品对象goodsDetail，若没有传入id则没有该对象
	 */
	@Override
	public Map<String,Object> init(Long id){
		Map<String, Object> params=new HashMap<>();
		if(id!=null){
			Goods goods=goodsDAO.getGoodsById(id);
			params.put("goods", goods);
		}
		//查询品牌和类型
		List<Brand> brandList=brandDAO.fetchBrands(new HashMap<String,Object>());
		List<Type> typeList=typeDAO.fetchTypes(new HashMap<String,Object>());
		params.put("brandList", brandList);
		params.put("typeList", typeList);
		
		return params;
	}
	
	/**
	 * 上传文件到文件服务器，使用ftp协议
	 * @param params 传入的参数，需要传入以下值：<br>
	 * 1，ftpHostAddress：文件服务器地址，String类型<br>
	 * 2，username：文件服务器登录用户名，String类型<br>
	 * 3，password：文件服务器登录密码，String类型<br>
	 * 4，uploadPath：上传路径，以“/”开始，表示从根路径开始<br>
	 * 5，fileName：上传文件名，String类型
	 * @param uploadStream 上传的文件流
	 * @return 包含有上传情况的消息的集合
	 */
	@Override
	public Result uploadToFtpServer(Map<String,String> params,InputStream uploadStream){
		Result result=new Result();
		try {
			//连接文件服务器
			ftpClient.connect(params.get("ftpHostAddress"));
			//登录，登录成功后才能进行上传下载文件
			boolean loginOK=ftpClient.login(params.get("username"),params.get("password"));
			if (ftpClient.isConnected()&&loginOK) {
				//设置要在哪个路径放置文件
				ftpClient.changeWorkingDirectory(params.get("uploadPath"));
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.storeFile(params.get("fileName"), uploadStream);
				result.setSuccess(true);
				result.setData(params.get("uploadPath")+"/"+params.get("fileName"));
			} 
		} catch (IOException e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setTips("上传到文件服务器失败");
		} finally {
			if (ftpClient!=null&&ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//返回消息
		return result;
	}

	@Override
	public Goods saveGoods(Goods goods){
		goods.setId(generator.generatePrimaryKey(8));
		int rows=goodsDAO.saveGoods(goods);
		return rows==1?goodsDAO.getGoodsById(goods.getId()):null;
	}

	@Override
	public List<Goods> showGoods(Map<String, Object> condition) {
		return goodsDAO.fetchGoods(condition);
	}

	@Override
	public boolean deleteGoods(long id){
		int rows=goodsDAO.removeGoods(id);
		return rows==1;
	}

	@Override
	public Goods getGoodsById(long id){
		return goodsDAO.getGoodsById(id);
	}

	@Override
	public Goods updateGoods(Goods goods) {
		int i=goodsDAO.updateGoods(goods);
		return i==1?goods:null;
	}
}
