package com.buxianglong.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Split {
	
	private String filePath = null;
	
	private String destPath = null;
	
	public Split(String filePath,String destPath){
		this.filePath = filePath;
		this.destPath = destPath;
	}
	
	public void doSplit(long splitSize)throws Exception{
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(destPath);
		BufferedWriter bw = new BufferedWriter(fw);
		
		char[] buf = new char[1];
		long totalCount = 0;
		long textSize = 0;
		while(br.read(buf)>0 ){
			if(buf[0]>=0x4E00 && buf[0]<=0X9FA5){
				textSize++;
			}
		}
		
		System.out.println("book size count:"+textSize);
		fr.close();
		br.close();
		fr = new FileReader(filePath);
		br = new BufferedReader(fr);
		bw.write("文章总字数："+textSize+"\n\n");
		while(br.read(buf)>0){
			bw.write(buf);
			if(buf[0]>=0x4E00 && buf[0]<=0X9FA5){
				totalCount++;
				if(totalCount%splitSize==0){
					bw.write('\n');
					bw.write('\n');
					bw.write("<!-- (您已阅读 "+totalCount+" 字,进度："+(totalCount*100)/(double)textSize+"%) -->");
					System.out.println("==>(you have read "+totalCount+" characters,progress:"+(totalCount*100)/(double)textSize+"%)");
					bw.write('\n');
					bw.write('\n');
				}
			}
		}
		bw.write('\n');
		bw.write('\n');
		bw.write("您已阅读 "+totalCount+" 字,全书已读完！");
		System.out.println("you have read "+totalCount+" characters,done !");
		fr.close();
		bw.close();
	}
}
