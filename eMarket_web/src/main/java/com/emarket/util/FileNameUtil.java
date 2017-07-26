package com.emarket.util;

import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.FormatStringPrimaryKeyGenerator;
import com.shui.generator.impl.StringPrimaryKeyGenerator;

public class FileNameUtil {
	
	private static FormatStringPrimaryKeyGenerator generator=new FormatStringPrimaryKeyGenerator();
	
	static{
		if(generator!=null){
			generator.formatPattern("{date:yyyyMMdd}-{string:8}");
		}
	}
	
	public static String createNewFileName(String fileName){
		String suffix=fileName.substring(fileName.lastIndexOf("."));
		if(suffix!=null&&!suffix.isEmpty()){
			return generator.generatePrimaryKey()+suffix;
		}else{
			return generator.generatePrimaryKey();
		}
	}
}
