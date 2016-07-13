package com.demo.file;

import java.io.File;

/**
 * 文件和目录操作
 * 
 * @author huawangxin
 *
 */
public class DoIO {

	public static void main(String[] args) {
		File  file=new File("d:/demo");
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++){
			//列出目录下所有文件
			if(files[i].isFile()){
				System.out.println(files[i]);
			}
			//列出目录下所有子目录
			if(files[i].isDirectory()){
				System.out.println(files[i]);
			}
		}
		//判断文件和目录是否村在
		System.out.println(new File("d:/t.txt").exists());
	}

}
