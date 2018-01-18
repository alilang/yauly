package com.mg.mf;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("D:\\AAA", "bbb.txt");
        System.out.println(f.getAbsolutePath());
    }
}
