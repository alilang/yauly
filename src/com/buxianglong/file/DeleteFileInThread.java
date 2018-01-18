package com.buxianglong.file;

import java.io.File;

public class DeleteFileInThread implements Runnable {
	private static Object lock = new Object();
	private static int count=0;
	public void increase(){
		synchronized (lock) {
			count++;
			tell();
		}
	}
	
	public void decrease(){
		synchronized (lock) {
			count--;
			tell();
		}
	}
	
	public void tell(){
		System.out.println("Thread number: "+count);
	}
	private File file;
	public DeleteFileInThread(File file){
		this.file=file;
		increase();
	}
	@Override
	public void run() {
		if(file.isFile()){
			System.out.println("delete"+file.getPath());
		}else{
			File[] files = file.listFiles();
			for(int i=0;i<files.length;i++){
				if(files[i].isFile()){
					System.out.println("delete"+file.getPath());
				}else{
					new Thread(new DeleteFileInThread(files[i])).start();
				}
			}
		}
		decrease();
	}

}
