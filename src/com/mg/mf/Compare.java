package com.mg.mf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Compare {

    public static boolean isSpecialFile(String name)
    {
        if(name.contains("assets/migu") || name.contains("res/") || name.contains("assets/PresetBooks")
                || name.contains("assets/presetHotBook") || name.contains("assets/presetcover")
                || name.contains("assets/venus.zip") || name.contains("assets/MG") || name.contains("assets/mobilemusic_config.xml")
                || name.contains("assets/channel") || name.contains("assets/open_config") || name.contains("AndroidManifest.xml")
                || name.contains("mg20dss") || name.contains("libmg20p_") || name.contains("mg20css")
                || name.contains("MiguPay.Sdk15.Lib_") || name.contains("mgirid") || name.contains("libmg20pbase"))
        {
            return true;
        }
        return false;
    }
    
    public static void removeWhiteList(String path,String outFilePath,StringBuffer sb) throws Exception
    {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        File out = new File(outFilePath);
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(out));
        String message = null;
        while((message = br.readLine())!=null)
        {
            if(isSpecialFile(message))
            {
                br.readLine();
                br.readLine();
            }
            else
            {
                message = message.replaceAll(" ", "");
                message = message.replaceAll("\r", "");
                message = message.replaceAll("\n", "");
                message = message.replaceAll("\0", "");
                message = message.trim();
                if(message.length()>0){
                    sb.append(message);
                }

            }
        }
        outWriter.write(sb.toString());
        br.close();
        outWriter.close();
    }
    
    public static void main(String[] args) throws Exception{
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        removeWhiteList("D:/temp/orign.MF","D:/temp/before2.MF",sb1);
        removeWhiteList("D:/temp/before.MF","D:/temp/orign2.MF",sb2);
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        String storeMessage = null;
        do{
            index1 = sb1.indexOf("Name:", index1);
            index2 = sb1.indexOf("SHA1-Digest:", index1);
            index3 = sb1.indexOf("Name:", index2);
            if(index3<0)
            {
                storeMessage = sb1.substring(index1);
            }
            else{
                storeMessage = sb1.substring(index1,index3); 
                index1 = index3;
            }
            if(sb2.indexOf(storeMessage)<0)
            {
                System.out.println(storeMessage);
                System.out.println();
            }
        }while(index3>0);
        
    }

}
