package com.mg.mf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodIndex {
    String pidFormat = "(.*\\()(pid:\\d+)(\\).*)";
    String methodFormat = "(.*\\()(methodIndex:\\d+)(\\).*)";
    
    
    public String getData(String log, String format){
        String ret = null;
        Pattern  pattern = Pattern.compile(format); 
        Matcher  ma = pattern.matcher(log); 
        if(ma.find())
        {
            ret = ma.group(2);
        }
        return ret;
    }
    
    public boolean checkMethodIndex(File file) throws Exception
    {
        boolean ret = true;
        HashMap<String, String> map = new HashMap<String, String>();
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        String log = null;
        while((log = br.readLine())!=null)
        {
            if(!log.matches(methodFormat))
            {
                continue;
            }
            String methodIndex = getData(log, methodFormat);
            if(map.get(methodIndex) == null)
            {
                map.put(methodIndex, methodIndex);
            }
            else{
                System.out.println(methodIndex + "重复");
               ret = false;
            }
        }
        
        br.close();
        return ret;
    }
    
    public ArrayList<Integer> getMethodIndexs(File file, String format) throws Exception
    {
        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String log = null;
        while((log = br.readLine())!=null)
        {
            if(!log.matches(format))
            {
                continue;
            }
            String methodIndex = getData(log, format);
            String[] arr = methodIndex.split(":");
            if(null == map.get(arr[1]))
            {
                map.put(arr[1], arr[1]);
                list.add(Integer.valueOf(arr[1]));
            }
        }
        
        br.close();
        return list;
    }
    
    public ArrayList<String> getMethodPids(File file) throws Exception
    {
        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String log = null;
        while((log = br.readLine())!=null)
        {
            if(!log.matches(pidFormat))
            {
                continue;
            }
            String methodIndex = getData(log, pidFormat);
            String[] arr = methodIndex.split(":");
            String pid = arr[1];
            if(null == map.get(pid))
            {
                map.put(pid, pid);
                list.add(pid);
            }
        }
        
        br.close();
        return list;
    }
    
    
    static void testLog() throws Exception
    {
        MethodIndex m = new MethodIndex();
        File f = new File("d:\\method.txt");

        ArrayList<String> pids = m.getMethodPids(f);
        System.out.println(String.format("共发现%d个pid \r\n", pids.size()));
        for(int i=0;i<pids.size();i++)
        {
            System.out.println(pids.get(i));
        }
    }
    
    static void testOffset() throws Exception{
        FileInputStream fis = new FileInputStream(new File("d:\\a.dex"));
        int offSet = 0x28e4;
        int length = 104;
        byte[] b = new byte[length];
        fis.skip(offSet);
        fis.read(b, 0, length);
        for(int i=0;i<length;i++)
        {
            System.out.println(String.format("0x%02x", b[i]));
        }
        fis.close();
    }
    
    public static void main(String[] args) throws Exception{
        testLog() ;
    }

}
