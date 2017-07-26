package com.emarket.admin.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Goods;
import com.eMarket.model.vo.Result;

public interface GoodsManageService{

	/**
	 * 初始服务，用于跳转到添加或修改商品页面时需要从数据库中获取品牌和类型数据的情况
	 * @param id 添加商品时使用此方法请传入null，修改商品时使用此方法请传入需要修改的商品id
	 * @return 从数据库中查询出来的数据，其中包括：<br>
	 * 1，所有的品牌列表brandList
	 * 2，所有的类型列表typeList
	 * 3，若传入的id，则存在数据库中该id所指的商品对象goods，若没有传入id则没有该对象
	 */
	Map<String, Object> init(Long id);
	
	Goods saveGoods(Goods goods);

	/**
	 * 根据条件搜索商品
	 * @param condition 搜索条件
	 * @return 满足条件的商品
	 */
	List<Goods> showGoods(Map<String, Object> condition);

	/**
	 * 从数据库中删除一条商品详情记录
	 * @param id 要删除的商品详情的id
	 * @return 删除成功返回true,失败返回false
	 */
	boolean deleteGoods(long id);

	/**
	 * 上传文件到文件服务器，使用ftp协议
	 * @param uploadParam 传入的参数，需要传入以下值：<br>
	 * 1，ftpHostAddress：文件服务器地址，String类型<br>
	 * 2，username：文件服务器登录用户名，String类型<br>
	 * 3，password：文件服务器登录密码，String类型<br>
	 * 4，uploadPath：上传路径，以“/”开始，表示从根路径开始<br>
	 * 5，fileName：上传文件名，String类型
	 * @param uploadStream 上传的文件流
	 * @return 包含有上传情况的消息的集合
	 */
	Result uploadToFtpServer(Map<String,String> uploadParam, InputStream uploadStream);
	
	Goods getGoodsById(long id);
	
	Goods updateGoods(Goods goods);
}