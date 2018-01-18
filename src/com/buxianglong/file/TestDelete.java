package com.buxianglong.file;

import java.io.File;

public class TestDelete {

    public static void main(String[] args) {
        File file = new File("D:\\env\\android-sdk");
        long startTime = System.currentTimeMillis();
        DeleteFile df = new DeleteFile();
        df.init();
        // df.outPutFile(file, 0);
        // df.deleteCatagoryByName(file, 0, ".repo");
        // df.deleteFileInThread(file, 0);
        df.deleteFile(file, 0);
        df.destroy();

        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "毫秒");

    }

}
