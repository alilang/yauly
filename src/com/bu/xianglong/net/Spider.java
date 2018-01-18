package com.bu.xianglong.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {
    
    public void getContent()throws Exception
    {
        URL url = new URL("http://www.jbox.dk/sanos/source/lib/string.c.html");
        StringBuffer sb = new StringBuffer();
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String message="";
        while(null != (message=br.readLine()))
        {
            sb.append(message+"\r\n");
        }
        System.out.println(sb.toString());
        is.close();
    }
    
    public void getURL() throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader("d:/url.txt"));
        String message = "";
        Pattern pattern = Pattern.compile("href=\"(.+?)html\"");
        while(null != (message=br.readLine()))
        {
            Matcher matcher = pattern.matcher(message);
            while(matcher.find())
            {
                String url = matcher.group().replaceAll("\"", "").replaceAll("href=", "");
                url="http://www.jbox.dk/sanos/source/lib/" + url;
                System.out.println(url);
            }
        }
        br.close();
    }
    
    public static void main(String[] args) throws Exception{
        Spider spider = new Spider();
        spider.getContent();
    }

}
