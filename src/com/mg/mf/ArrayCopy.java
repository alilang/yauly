package com.mg.mf;

import java.util.Arrays;

public class ArrayCopy {

//    public static byte[] arrayConcat(byte[] a, byte[] b){
//        if(a == null || b == null){
//            return null;
//        }
//        
//        byte[] ret = null;
//        int len1 = a.length;
//        int len2 = b.length;
//        ret = new byte[len1+len2];
//        int index = 0;
//        for(int i = 0; i < a.length;i++){
//            ret[index] = a[i];
//            index++;
//        }
//        
//        for(int i = 0; i < b.length;i++){
//            ret[index] = b[i];
//            index++;
//        }
//        return ret;
//    }
    
    public static byte[] arrayConcat(byte[] a, byte[] b) {  
        byte[] result = Arrays.copyOf(a, a.length + b.length);  
        System.arraycopy(b, 0, result, a.length, b.length);  
        return result;  
      }  
    
    public static void main(String[] args) {
        byte[] a = {1,2,3};
        byte[] b = {4,5,6,7,8,9,10};
        byte[] all = arrayConcat(a, b);
        System.out.println(Arrays.toString(all));

    }

}
