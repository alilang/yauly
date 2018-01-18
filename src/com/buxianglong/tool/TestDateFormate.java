package com.buxianglong.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormate{

	public static void main(String[] args)  throws Exception{
		SimpleDateFormat sf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf2=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = "20150203095006";
		Date date = sf2.parse(dateStr);
		System.out.println(sf1.format(date));

	}

}
