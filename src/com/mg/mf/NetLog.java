package com.mg.mf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetLog {

    static class Statistic{
        int count;
        HashMap<String, Integer> addressMap = new HashMap<>();
    }
    
    public static void addStringIntMap(HashMap<String, Integer> addressMap, String key){
        Integer count = addressMap.get(key);
        if(null == count){
            addressMap.put(key, 1);
        }else{
            addressMap.put(key, count+1);
        }
        
    }
    
    
    public static String getAddress(String content){
        String ret = "unknown";
        Pattern  pattern=Pattern.compile("[a-zA-Z0-9]+\\.(com|cn|org|gov|net|me|cx|wang|cc|xin|top|red|pub|ink|info|xyz|win)"); 
        Matcher  ma=pattern.matcher(content); 
        while(ma.find()){  
            ret = ma.group();
            break;
        }
        if("unknown".equals(ret)){
            //System.out.println(content);
        }
        return ret;
    }
    
    public static String getIP(String content){
        String ret = null;
        Pattern  pattern=Pattern.compile("10\\.86\\.55\\.\\d+");   
        pattern=Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        Matcher  ma=pattern.matcher(content); 
        while(ma.find()){  
            ret = ma.group();
            break;
        }
        if(ret == null){
            System.out.println(content);
        }
        return ret;
    }
    
    public static List<Map.Entry<String, Integer>> getCountSortedMapList(HashMap<String, Integer> map)
    {
        if(null == map)
        {
            return null;
        }
        
        List<Map.Entry<String, Integer>> ret =
                new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        
        Collections.sort(ret, new Comparator<Map.Entry<String, Integer>>() {   
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
                return (o2.getValue() - o1.getValue()); 
            }
        }); 
        
        return ret;
    }
    
    
    public static void logSortedMapList(List<Map.Entry<String, Integer>> list)
    {
        if(null == list)
        {
            return;
        }
        for(int i = 0; i < list.size(); i++)
        {
            Map.Entry<String, Integer> e = list.get(i);
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
    
    public static void logSortedMapList(List<Map.Entry<String, Integer>> list,String append)
    {
        if(null == list)
        {
            return;
        }
        for(int i = 0; i < list.size(); i++)
        {
            Map.Entry<String, Integer> e = list.get(i);
            System.out.println(append + e.getKey() + ":" + e.getValue());
        }
    }
    
    public static void printUserInfo(HashMap<String, Statistic> users){
        
        List<Map.Entry<String, Statistic>> list =
                new ArrayList<Map.Entry<String, Statistic>>(users.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Statistic>>() {   
            public int compare(Map.Entry<String, Statistic> o1, Map.Entry<String, Statistic> o2) {    
                int s1 = o1.getValue().count;
                int s2 = o2.getValue().count;
                return (s2 - s1); 
            }
        }); 
        
        for(int i=0;i<list.size();i++){
            Map.Entry<String, Statistic> e = list.get(i);
            System.out.println(String.format("用户：%s, 次数：%d", e.getKey(),e.getValue().count));
            List<Map.Entry<String, Integer>> addrs =  getCountSortedMapList(e.getValue().addressMap);
            logSortedMapList(addrs, "\t");
        }
    }
    
    public static void parseLogFile()throws Exception{
        HashMap<String, Statistic> user = new HashMap<String, Statistic>();
        
        BufferedReader br  = new BufferedReader(new FileReader("D:\\access.log"));
        String message = null;
        while((message=br.readLine())!=null){
            if(message.trim().length()<=0){
                continue;
            }
            String ip = getIP(message);
            if(null == ip){
                continue;
            }
            String address = getAddress(message);
            
            Statistic info = user.get(ip);
            if(null == info){
                info = new Statistic();
                info.count=1;
                addStringIntMap(info.addressMap, address);
                user.put(ip, info);
            }else{
                info.count+=1;
                addStringIntMap(info.addressMap, address);
            }
        }
        printUserInfo(user);
        br.close();
    }
   
    public static void printSimble() throws Exception{
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader br  = new BufferedReader(new FileReader("D:\\access.log"));
        String message = null;
        while((message=br.readLine())!=null){
            if(message.trim().length()<=0){
                continue;
            }
            String ip = getIP(message);
            addStringIntMap(map, ip);
        }
        
        List<Map.Entry<String, Integer>> list = getCountSortedMapList(map);
        logSortedMapList(list);
        br.close();
    }
    public static void main(String[] args)throws Exception {
        parseLogFile();
        //System.out.println(new Date(1491522212466l));
    }

}
