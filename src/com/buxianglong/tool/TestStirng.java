package com.buxianglong.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestStirng {
	private static final int appid_len = 8;
	private static final int imei_len = 15;
	private static final int imsi_len = 15;
	private static final int Base64_EMMC_md5_len = 24;
	private static final int rand_len = 16;
	private static final int time_len = 14;
	private static final int apk_status_len = 1;
	private static final int api_call_count_len = 4;
	private static final int billing_call_count_len = 4;
	private static final int start_up_times_len = 4;
	private static final int sessionID_change_len = 4;
	private static final int api_to_startup_len = 4;
	private static final int api_to_billing_len = 4;
	private static final int preserved_len = 200;
	private static final int version_len = 1;
	private static final int hmac_len = 28;
	
	private static final int session_len = 8;
	private static final int IrdeoVCode_len = 6;
	
	private static String getDateStr(String dateStr){
		String result = "";
		SimpleDateFormat sf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf2=new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date date = sf2.parse(dateStr);
			result = sf1.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static void SessionReqProcessor(String message)
	{
		String outPut = "SessionReqProcessor\t";
		
		//get java time
		String reqtime = "";
		int timeBeginIndex = message.indexOf("<requestTime>");
		int timeEndIndex = message.indexOf("</requestTime>");
		if(timeBeginIndex>0){
			reqtime = message.substring(timeBeginIndex+13,timeEndIndex);
		}
		
		int index = message.indexOf("</charge_request>");
		index+=17;
		String appid = message.substring(index,index+appid_len);
		outPut = outPut+appid+"\t";
		index+=appid_len;
		
		String imei = message.substring(index,index+imei_len);
		outPut = outPut+imei+"\t";
		index+=imei_len;
		
		String imsi = message.substring(index,index+imsi_len);
		outPut = outPut+imsi+"\t";
		index+=imsi_len;
		
		String Base64_EMMC_md5 = message.substring(index,index+Base64_EMMC_md5_len);
		outPut = outPut+Base64_EMMC_md5+"\t";
		index+=Base64_EMMC_md5_len;
		
		String rand = message.substring(index,index+rand_len);
		outPut = outPut+rand+"\t";
		index+=rand_len;
		
		String time = message.substring(index,index+time_len);
		outPut = outPut+getDateStr(time)+"\t";
		index+=time_len;
		
		outPut = outPut+reqtime+"\t";
		
		String apk_status = message.substring(index,index+apk_status_len);
		outPut = outPut+apk_status+"\t";
		index+=apk_status_len;
		
		String api_call_count = message.substring(index,index+api_call_count_len);
		outPut = outPut+api_call_count+"\t";
		index+=api_call_count_len;
		
		String billing_call_count = message.substring(index,index+billing_call_count_len);
		outPut = outPut+billing_call_count+"\t";
		index+=billing_call_count_len;
		
		String start_up_times = message.substring(index,index+start_up_times_len);
		outPut = outPut+start_up_times+"\t";
		index+=start_up_times_len;
		
		String sessionID_change = message.substring(index,index+sessionID_change_len);
		outPut = outPut+sessionID_change+"\t";
		index+=sessionID_change_len;
		
		String api_to_startup = message.substring(index,index+api_to_startup_len);
		outPut = outPut+api_to_startup+"\t";
		index+=api_to_startup_len;
		
		String api_to_billing = message.substring(index,index+api_to_billing_len);
		outPut = outPut+api_to_billing+"\t";
		index+=api_to_billing_len;
		
		index+=preserved_len;
		
		String version = message.substring(index,index+version_len);
		outPut = outPut+version+"\t";
		index+=version_len;
		
		String hmac = message.substring(index,index+hmac_len);
		outPut = outPut+hmac+"\t";
		index+=hmac_len;
		
		System.out.println(outPut);
	}
	
	private static void BillingReqProcessor(String message)
	{
		String outPut = "BillingReqProcessor\t";
		
		//get java time
		String reqtime = "";
		int timeBeginIndex = message.indexOf("<requestTime>");
		int timeEndIndex = message.indexOf("</requestTime>");
		if(timeBeginIndex>0){
			reqtime = message.substring(timeBeginIndex+13,timeEndIndex);
		}
		
		int index = message.indexOf("</charge_request>");
		index+=17;
		String appid = message.substring(index,index+appid_len);
		outPut = outPut+appid+"\t";
		index+=appid_len;
		
		String session = message.substring(index,index+session_len);
		index+=session_len;
		
		String IrdeoVCode = message.substring(index,index+IrdeoVCode_len);
		index+=IrdeoVCode_len;
		
		String imei = message.substring(index,index+imei_len);
		outPut = outPut+imei+"\t";
		index+=imei_len;
		
		String imsi = message.substring(index,index+imsi_len);
		outPut = outPut+imsi+"\t";
		index+=imsi_len;
		
		String Base64_EMMC_md5 = message.substring(index,index+Base64_EMMC_md5_len);
		outPut = outPut+Base64_EMMC_md5+"\t";
		index+=Base64_EMMC_md5_len;
		
		String rand = message.substring(index,index+rand_len);
		outPut = outPut+rand+"\t";
		index+=rand_len;
		
		String time = message.substring(index,index+time_len);
		outPut = outPut+getDateStr(time)+"\t";
		index+=time_len;
		
		outPut = outPut+reqtime+"\t";
		
		String apk_status = message.substring(index,index+apk_status_len);
		outPut = outPut+apk_status+"\t";
		index+=apk_status_len;
		
		String api_call_count = message.substring(index,index+api_call_count_len);
		outPut = outPut+api_call_count+"\t";
		index+=api_call_count_len;
		
		String billing_call_count = message.substring(index,index+billing_call_count_len);
		outPut = outPut+billing_call_count+"\t";
		index+=billing_call_count_len;
		
		String start_up_times = message.substring(index,index+start_up_times_len);
		outPut = outPut+start_up_times+"\t";
		index+=start_up_times_len;
		
		String sessionID_change = message.substring(index,index+sessionID_change_len);
		outPut = outPut+sessionID_change+"\t";
		index+=sessionID_change_len;
		
		String api_to_startup = message.substring(index,index+api_to_startup_len);
		outPut = outPut+api_to_startup+"\t";
		index+=api_to_startup_len;
		
		String api_to_billing = message.substring(index,index+api_to_billing_len);
		outPut = outPut+api_to_billing+"\t";
		index+=api_to_billing_len;
		
		index+=preserved_len;
		
		String version = message.substring(index,index+version_len);
		outPut = outPut+version+"\t";
		index+=version_len;
		
		String hmac = message.substring(index,index+hmac_len);
		outPut = outPut+hmac+"\t";
		index+=hmac_len;
		
		outPut = outPut+session+"\t";
		outPut = outPut+IrdeoVCode+"\t";
		
		System.out.println(outPut);
	}
	
	private static void SmsTokenReqProcessor(String message){
		String outPut = "SmsTokenReqProcessor\t";
		//get java time
		String reqtime = "-------------------";
		int timeBeginIndex = message.indexOf("<requestTime>");
		int timeEndIndex = message.indexOf("</requestTime>");
		if(timeBeginIndex>0){
			reqtime = message.substring(timeBeginIndex+13,timeEndIndex);
		}
		
		int index = message.indexOf("Decoded request:");
		index+=17;
		String appid = message.substring(index,index+appid_len);
		outPut = outPut+appid+"\t";
		index+=appid_len;
		
		String imei = message.substring(index,index+imei_len);
		outPut = outPut+imei+"\t";
		index+=imei_len;
		
		String imsi = message.substring(index,index+imsi_len);
		outPut = outPut+imsi+"\t";
		index+=imsi_len;
		
		String Base64_EMMC_md5 = message.substring(index,index+Base64_EMMC_md5_len);
		outPut = outPut+Base64_EMMC_md5+"\t";
		index+=Base64_EMMC_md5_len;
		
		String rand = message.substring(index,index+rand_len);
		outPut = outPut+rand+"\t";
		index+=rand_len;
		
		String time = message.substring(index,index+time_len);
		outPut = outPut+getDateStr(time)+"\t";
		index+=time_len;
		
		outPut = outPut+reqtime+"\t";
		
		String apk_status = message.substring(index,index+apk_status_len);
		outPut = outPut+apk_status+"\t";
		index+=apk_status_len;
		
//		String api_call_count = message.substring(index,index+api_call_count_len);
//		outPut = outPut+api_call_count+"\t";
//		index+=api_call_count_len;
//		
//		String billing_call_count = message.substring(index,index+billing_call_count_len);
//		outPut = outPut+billing_call_count+"\t";
//		index+=billing_call_count_len;
//		
//		String start_up_times = message.substring(index,index+start_up_times_len);
//		outPut = outPut+start_up_times+"\t";
//		index+=start_up_times_len;
//		
//		String sessionID_change = message.substring(index,index+sessionID_change_len);
//		outPut = outPut+sessionID_change+"\t";
//		index+=sessionID_change_len;
//		
//		String api_to_startup = message.substring(index,index+api_to_startup_len);
//		outPut = outPut+api_to_startup+"\t";
//		index+=api_to_startup_len;
//		
//		String api_to_billing = message.substring(index,index+api_to_billing_len);
//		outPut = outPut+api_to_billing+"\t";
//		index+=api_to_billing_len;
//		
//		index+=preserved_len;
//		
//		String version = message.substring(index,index+version_len);
//		outPut = outPut+version+"\t";
//		index+=version_len;
//		
//		String hmac = message.substring(index,index+hmac_len);
//		outPut = outPut+hmac+"\t";
//		index+=hmac_len;
		
		System.out.println(outPut);
	}
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("D://request.txt");
		BufferedReader br = new BufferedReader(fr);
		String message = null;
		while((message = br.readLine()) != null){
			int beginIndex = message.indexOf("SessionReqProcessor");
			if(beginIndex>0){
				SessionReqProcessor(message);
			}else{
				beginIndex = message.indexOf("BillingReqProcessor");
				if(beginIndex>0)
				{
					BillingReqProcessor(message);
				}else{
					beginIndex = message.indexOf("SmsTokenReqProcessor");
					if(beginIndex>0)
					{
						SmsTokenReqProcessor(message);
					}
				}
			}
		}
		fr.close();
		br.close();
	}

}
