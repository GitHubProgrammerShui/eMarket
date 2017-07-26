package eMarket_core;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eMarket.model.po.Customer;
import com.emarket.dao.CustomerDAO;

import junit.framework.TestCase;

public class TestEMarketCore extends TestCase{
	
//	@Test
//	public void testBrandDAO(){
//		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		CustomerDAO customerDAO=context.getBean(CustomerDAO.class);
//		Customer customer=customerDAO.getCustomerByUsername("guest");
//		System.out.println(customer);
//	}
	
	@Test
	public void testBrand(){
		System.out.println("brand");
	}
}
