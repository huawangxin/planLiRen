package com.demo.file;

import java.io.File;

/**
 * �ļ���Ŀ¼����
 * 
 * @author huawangxin
 *
 */
public class DoIO {

	public static void main(String[] args) {
		File  file=new File("d:/demo");
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++){
			//�г�Ŀ¼�������ļ�
			if(files[i].isFile()){
				System.out.println(files[i]);
			}
			//�г�Ŀ¼��������Ŀ¼
			if(files[i].isDirectory()){
				System.out.println(files[i]);
			}
		}
		//�ж��ļ���Ŀ¼�Ƿ����
		System.out.println(new File("d:/t.txt").exists());
	}

}
