package com.mg.mf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BillingReq {

    public static void extractYStr(String message, BufferedWriter bw)throws Exception
    {
        if(!message.contains("|01|0151|0000|0335|12|6|"))
        {
            return;
        }
        int beginIndex = message.indexOf("</request>-|-");
        int endIndex = message.indexOf("-|--|--|-<?xml version=");
        String str = message.substring(beginIndex+13, endIndex);
        String[] splits = str.split("\\|");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< splits.length; i++)
        {
            sb.append(splits[i]+"\t");
        }
        sb.append("\n");
        bw.write(sb.toString());
    }
    public static void testBillingReq(String path, String destPath) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
        String message = null;
        while((message = br.readLine()) != null)
        {
            if(message.contains("status="))
            {
                extractYStr(message, bw);
            }
        }
        
        br.close();
        bw.close();
                
    }
    
    public static void testBilling(String path, String destPath) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
        String message = null;
        while((message = br.readLine()) != null)
        {
            if(!message.contains("status="))
            {
                bw.write(message + "\r\n");
                System.out.println(message);
            }
        }
        
        br.close();
        bw.close();
                
    }
    
    public static void main(String[] args) throws Exception{
        testBillingReq("D://00001580_billing.log", "D://dest.log");
        //testBilling("D://00001580_billing.log", "D://dest.log");

    }

}
