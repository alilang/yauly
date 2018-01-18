package com.mg.mf;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoadResource {

    
    public static String getResourceTxt(Class clazz, String resPath) throws IOException {
        StringBuffer sb = new StringBuffer();
        InputStream is = clazz.getClassLoader().getResourceAsStream(resPath);

        try (BufferedInputStream in = new BufferedInputStream(is)) {
            int byteRead = 0;
            byte[] buffer = new byte[1024];

            while ((byteRead = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, byteRead));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws Exception{

        String text = getResourceTxt(LoadResource.class, "system-property.conf");
        System.out.println(text);
    }

}
