package com.mg.mf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;

public class RandomLog {

    
    public static void checkLog(HashMap<String, Integer> hm, File file) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String message = null;
        int count=0;
        while((message = br.readLine()) != null && message.trim().length()>0)
        {
            count++;
            if(hm.get(message) != null)
            {
                System.out.println(message + "!!!!!!!");
            }
            if(count%1000000 == 0)
            {
                System.out.println("\t " + count);
            }
        }
        
        if(count%1000000 != 0)
        {
            System.out.println("\t " + count);
        }
        br.close();
    }
    
    public static void handleLog(File file, File file2) throws Exception
    {
        System.out.println(file.getName() + " : " + file2.getName());
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String message = null;
        int count = 0;
        while((message = br.readLine()) != null && message.trim().length()>0)
        {
            count ++;
            String randomStr = message;
            if(hm.get(randomStr) == null)
            {
                hm.put(randomStr, 1);
            }
            else
            {
                int value = hm.get(randomStr);
                hm.put(randomStr, value + 1);
                System.out.println(randomStr + ":" + file.getName());
            }
            if(hm.size()>=1000000)
            {
                System.out.println(count);
                checkLog(hm, file2);
                hm.clear();
                System.gc();
            }
        }
        
        if(hm.size()>0)
        {
            System.out.println(count);
            checkLog(hm, file2);
            hm.clear();
            System.gc();
        }
        System.out.println("total count:" + count);
        br.close();
    }
    
    public static void main(String[] args) throws Exception{
        
        File file = new File("D:/randomlog");
        File[] files = file.listFiles(new FileFilter() {
            
            @Override
            public boolean accept(File pathname) {
                // TODO Auto-generated method stub
                if(pathname.getName().contains("random"))
                {
                    return true;
                }
                return false;
            }
        });
        
        
        handleLog(files[0], files[1]);
    }

}
