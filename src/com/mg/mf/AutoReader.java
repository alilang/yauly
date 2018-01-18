package com.mg.mf;

import java.util.Date;
import java.util.Random;

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
        // TODO Auto-generated method stub
        long startTime = System.currentTimeMillis();
        while(true)
        {
            int sleepTime = getRandom(20, 40);
            sleepTime = 1000*sleepTime + getRandom(0, 1000);
            //System.out.println("Read " + sleepTime + " miliseconds");
            Thread.sleep(sleepTime);
            if(new Date().getHours()<5)
            {
                //continue;
            }
            int startX = getRandom(startX1, startX2);
            int startY = getRandom(startY1, endY2);
            
            int endX = getRandom(endX1, endX2);
            int endY = getRandom(endY1, endY2);
            
            String cmd = String.format("adb shell input swipe %d %d %d %d", startX, startY, endX, endY);
            //System.out.println(cmd);
            try {
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            //System.out.println("minutes: " + (endTime - startTime)/60000);
        }
        

    }

}