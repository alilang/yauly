package com.mg.mf;

import java.util.Random;
import java.util.Scanner;

public class AutoClick {

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
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        while(!"qqq".equals(read))
        {
            int startX = getRandom(startX1, startX2);
            int startY = getRandom(startY1, endY2);
            
            int endX = getRandom(endX1, endX2);
            int endY = getRandom(endY1, endY2);
            
            String[] location = read.split(" ");
            Double x = Double.valueOf(location[0]);
            Double y = Double.valueOf(location[1]);
            Double z = Math.sqrt(x*x + y*y);
            System.out.println("length:" + z);
            int time = (int)(z*4 + 50);
            
            String cmd = String.format("adb shell input swipe %d %d %d %d %d", startX, startY, endX, endY, time);
            System.out.println(cmd);
            try {
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {
            }
            read = scan.nextLine();
        }
        
        scan.close();
    }

}
