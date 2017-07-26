package com.emarket.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.Brand;
import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Market;
import com.eMarket.model.po.Type;
import com.emarket.admin.service.FactoryService;
import com.emarket.dao.BrandDAO;
import com.emarket.dao.FactoryDAO;
import com.emarket.dao.GoodsDAO;
import com.emarket.dao.TypeDAO;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.LongPrimaryKeyGenerator;

@Service("factoryService")
public class FactoryServiceImpl implements FactoryService{
	
	@Autowired
	private FactoryDAO factoryDAO;
	@Autowired
	private BrandDAO brandDAO;
	@Autowired
	private TypeDAO typeDAO;
	@Autowired
	private GoodsDAO goodsDAO;
	
	private LengthPrimaryKeyGenerator<Long> generator=new LongPrimaryKeyGenerator();
	
	@Override
	public boolean saveOrAddFactoryItem(FactoryItem factoryItem){
		int i=0;
		FactoryItem item=null;
		if(factoryItem.getGoods()!=null){
			long id=factoryItem.getGoods().getId();
			item=this.getFactoryItemByGoodsId(id,factoryItem.getMarket().getId());
		}
		if(item!=null){
			System.out.println("添加");
			i=factoryDAO.addFactory(item.getId(),factoryItem.getAmount());
			System.out.println(i);
		}else{
			factoryItem.setId(generator.generatePrimaryKey(9));
			i=factoryDAO.saveFactory(factoryItem);
		}
		return i==1;
	}
	
	@Override
	public List<FactoryItem> fetchFactoryItem(Map<String,Object> condition){
		return factoryDAO.fetchFactoryItem(condition);
	}
	
	@Override
	public boolean removeFactoryItem(Long id){
		return factoryDAO.removeFactory(id)==1;
	}
	
	@Override
	public List<Brand> listBrand(){
		return brandDAO.fetchBrands(new HashMap<String,Object>());
	}
	
	@Override
	public List<Type> listType(){
		return typeDAO.fetchTypes(new HashMap<String,Object>());
	}
	
	@Override
	public List<Goods> fetchGoodsByBrandAndType(long brandId,long typeId){
		Map<String,Object> condition=new HashMap<>();
		condition.put("brand_id", brandId);
		condition.put("type_id", typeId);
		return goodsDAO.fetchGoods(condition);
	}

	@Override
	public FactoryItem createItem(long goodsId,long marketId,int quantity) {
		FactoryItem item=new FactoryItem();
		
		Goods goods = new Goods();
		goods.setId(goodsId);
		item.setGoods(goods);
		
		Market market = new Market();
		market.setId(marketId);
		item.setMarket(market);
		
		item.setAmount(quantity);
		return item;
	}
	
	private FactoryItem getFactoryItemByGoodsId(long goodsId,long marketId){
		HashMap<String, Object> condition = new HashMap<>();
		condition.put("goodsId",goodsId);
		condition.put("marketId", marketId);
		List<FactoryItem> items=factoryDAO.fetchFactoryItem(condition);
		if(items.isEmpty()){
			return null;
		}else{
			return items.get(0);
		}
	}
}
