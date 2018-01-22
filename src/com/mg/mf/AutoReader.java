package com.mg.mf;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoReader {

    static int startX1 = 987;
    static int startX2 = 855;
    static int startY1 = 999;
    static int startY2 = 970;
    
    static int endX1 = 537;
    static int endX2 = 330;
    static int endY1 = 1265;
    static int endY2 = 1325;
    
    public static int getRandom(int start, int end)
    {
        int ret = 0;
        Random random = new Random(System.currentTimeMillis());
        ret = start + (int)((end - start)*random.nextFloat());
        return ret;
    }
    
    public static void main(String[] args) throws Exception{
        //adb shell dumpsys window  | find "init="
        int width = 0;
        int height = 0;
        try{
            InputStream is = Runtime.getRuntime().exec("adb shell wm size").getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();
            System.out.println(line);
            br.close();
            is.close();
            Pattern p = Pattern.compile("[0-9]+");   
            Matcher m = p.matcher(line);
            if(m.find())
            {
                width = Integer.valueOf(m.group(0));
            }
            if(m.find()){
                height = Integer.valueOf(m.group(0));
            }
            
            System.out.println(String.format("screen width:%d, height:%d", width, height));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        while(true)
        {
            if(width > 0 && height > 0)
            {
                startX1 = (startX1*width)/1080;
                startX2 = (startX2*width)/1080;
                endX1 = (endX1*width)/1080;
                endX2 = (endX2*width)/1080;
                
                startY1 = (startY1*height)/1920;
                startY2 = (startY2*height)/1920;
                endY1 = (endY1*height)/1920;
                endY2 = (endY2*height)/1920;
            }
            int startX = getRandom(startX1, startX2);
            int startY = getRandom(startY1, startY2);
            
            int endX = getRandom(endX1, endX2);
            int endY = getRandom(endY1, endY2);
            
            int dual = getRandom(250, 400);
            
            String cmd = String.format("adb shell input swipe %d %d %d %d %d", startX, startY, endX, endY, dual);
            System.out.println(cmd);
            try {
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int sleepTime = getRandom(20, 40);
            sleepTime = 1000*sleepTime + getRandom(0, 1000);
            Thread.sleep(sleepTime);
        }
    }

}
