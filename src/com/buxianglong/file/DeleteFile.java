package com.buxianglong.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFile {

    private BufferedWriter bw;

    public void log(String log, int level) {
        try {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < level; i++) {
                sb.append("	");
            }
            sb.append(log);
            sb.append("\r\n");
            synchronized (bw) {
                bw.write(sb.toString());
            }
            System.out.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        try {
            bw = new BufferedWriter(new FileWriter("D:\\log.txt", false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFile(File file, int level) {
        String fileName = file.getName();
        if (file.isFile()) {
            boolean ret = file.delete();
            if (ret) {
                log(fileName + "@delete succceed!", level);
            } else {
                log(fileName + "@delete Filed!", level);
            }
        } else {
            // 删除文件夹下的每一个目录
            log(fileName + "#catagory delete begin----------", level);
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i], level + 1);
                }
                boolean ret = file.delete();
                if (ret) {
                    log(fileName + "#catagory deleted", level);
                } else {
                    log(fileName + "#catagory delete failed", level);
                }
            }

        }
    }
    
    public void deleteFileInThread(final File file, final int level) {
        String fileName = file.getName();
        if (file.isFile()) {
            boolean ret = file.delete();
            if (ret) {
                log(fileName + "@delete succceed!", level);
            } else {
                log(fileName + "@delete Filed!", level);
            }
        } else {
            // 删除文件夹下的每一个目录
            log(fileName + "#catagory delete begin----------", level);
            final File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    final int j = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("create thread for:" + files[j].getPath()+"level:" + (level+1));
                            deleteFileInThread(files[j], level+1);
                        }
                    }).start();
                }
            }

        }
    }
    
    public void deleteCatagoryByName(final File file, final int level, final String name) {
        String fileName = file.getName();
        if (file.isFile()) {
            return;
        } 
        
        if(name.equals(fileName)){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    deleteFile(file, level);
                }
            }).start();
        }else{
            // 删除文件夹下的每一个目录
            final File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    final int j = i;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            deleteCatagoryByName(files[j], level + 1, name);
                        }
                    }).start();
                }
            }
        }
    }

    public void outPutFile(File file, int level) {
        if (file.isFile()) {
            log(file.getPath(), level);
        } else {
            log(file.getPath() + "----------", level);
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    outPutFile(files[i], level + 1);
                }
            } else {
                System.out.println("异常");
            }

        }
    }
}
