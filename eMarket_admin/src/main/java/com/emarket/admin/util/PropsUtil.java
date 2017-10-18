package com.emarket.admin.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jdom.JDOMException;

import com.shui.reader.PropertiesReader;

/**
 * 用于读取系统配置文件的类
 * @author shuibaoqin
 *
 */
public class PropsUtil {
	
	private static PropertiesReader reader;
	
	static{
		if(reader==null){
			reader=new PropertiesReader();
			reader.load("classpath:application.xml");
		}
	}
	
	/**
	 * 如果获取的值是String类型，使用此方法，当获取的值类型不匹配时会返回null
	 * @param key 要获取的值的key
	 * @return 找到对应的值则返回此值，没有找到则返回null
	 */
	public static String getString(String key){
		return reader.getStringValue(key);
	}
	
	/**
	 * 如果获取的值是List类型，使用此方法，当获取的值类型不匹配时会返回null
	 * @param key 要获取的值的key
	 * @return 找到对应的值返回此值，没有找到则返回null
	 */
	public static List<String> getList(String key){
		return reader.getListValue(key);
	}
	
	/**
	 * 如果获取的值是Map类型，使用此方法，当获取的值类型不匹配时会返回null
	 * @param key 要获取的值的key
	 * @return 找到对应的值返回此值，没有找到则返回null
	 */
	public static Map<String, String> getMap(String key){
		return reader.getMapValue(key);
	}
}
