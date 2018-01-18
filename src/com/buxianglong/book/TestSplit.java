package com.buxianglong.book;

public class TestSplit {

    public static void main(String[] args) throws Exception {
        /*
        if (args.length == 3) {
            System.out.println("split size:"+args[0]);
            System.out.println("src file:"+args[1]);
            System.out.println("dest file:"+args[2]);
            int size = Integer.valueOf(args[0]);
            Split split = new Split(args[1],args[2]);
            split.doSplit(size);
        } else {
            System.out.println("please run with args: <splitSize> <srcFile> <destFile>,and srcFile must be encoded by UTF-8");
        }
        */
        
        Split split = new Split("d:/盗墓笔记全集.txt","d:/bxl_盗墓笔记全集.txt");
        split.doSplit(1000);
    }

}
