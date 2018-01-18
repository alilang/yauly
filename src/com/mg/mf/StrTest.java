package com.mg.mf;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrTest {

    public static void test()
    {
        String message = "XXXXXXXXXXXXXX<img src='http://answer.cloudsdee.com/uploads/answer/20161010/2b2a8362914539e5aef3d6af56d170bd.png'/>XXXXX";
        Pattern pattern = Pattern.compile("src='(.*)'");
        Matcher matcher = pattern.matcher(message);
        while(matcher.find())
        {
            String url = matcher.group(1);
            System.out.println(url);
        }
    }
    
    public static void test3()
    {
        String message = "dfsfsdfdsfdsfsdfsd   eeehttp://www.4byte.cn/question/58125/make-a-clickable-link-in-an-nsattributedstring-for-a-uitextfield-or-uilabel.html\n<img src='http://answer.cloudsdee.com/uploads/answer/20161010/2b2a8362914539e5aef3d6af56d170bd.png'/>";
        Pattern pattern = Pattern.compile("(http.*html)(.|\\s)*src='(.*)'");
        Matcher matcher = pattern.matcher(message);
        if(matcher.find())
        {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(3));
        }
    }
    
    public static void test4(){
        String name = "assets/aa.so";
        String file = name.substring(name.lastIndexOf('@')+1);
        System.out.println(file);
    }
    
    
    public static int compareVersion(String v1,String v2){
        int ret = 0;
        if(v1==null || v2==null){
            return ret;
        }
        
        if(v1.equals(v2)){
            return ret;
        }
        
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");
        if(arr1.length!=3 || arr2.length!=3){
            return ret;
        }
        
        if(Integer.valueOf(arr1[0])>Integer.valueOf(arr2[0])){
            ret = 1;
            return ret;
        }else if(Integer.valueOf(arr1[0])<Integer.valueOf(arr2[0])){
            ret = -1;
            return ret;
        }else if(Integer.valueOf(arr1[1])>Integer.valueOf(arr2[1])){
            ret = 1;
            return ret;
        }else if(Integer.valueOf(arr1[1])<Integer.valueOf(arr2[1])){
            ret = -1;
            return ret;
        }else if(Integer.valueOf(arr1[2])>Integer.valueOf(arr2[2])){
            ret = 1;
            return ret;
        }else if(Integer.valueOf(arr1[2])<Integer.valueOf(arr2[2])){
            ret = -1;
            return ret;
        }else{
            ret = 0;
        }
        
        
        return ret;
    }
    
    public static void main(String[] args) {
        String v1 = "Flyme 6";
        String v2 = "Flyme 5.2.1 1Q";
        System.out.println(v1.compareTo(v2));
    }

}
