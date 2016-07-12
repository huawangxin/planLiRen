package com.demo.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 将文件夹a(包括其下所有子文件夹和文件)复制到文件夹b下。
 * 要求:使用10个线程同时进行，每一个线程独立处理一个文件。
 * 
 * @author huawangxin
 *
 */
public class CopyFile {
	MyThread[] threads=new MyThread[10];
	public int n=0;
	public CopyFile() {
		for(int i=0;i<threads.length;i++){
			threads[i]=new MyThread();
		}
	}
	
	public static void main(String[] args) throws Exception {
		//这两个都要是文件夹路径
		new CopyFile().copyDirectionry(new File("C:\\Users\\Administrator\\Desktop\\a"), new File("C:\\Users\\Administrator\\Desktop\\c"));
	}

	public void copyDirectionry(File sourceDir,File targetDir) throws Exception{
		if(!sourceDir.exists()){
			sourceDir.mkdirs();
		}else if(!targetDir.exists()){
			targetDir.mkdirs();
		}
		File[] file=sourceDir.listFiles();
		for(int i=0;i<file.length;i++){
			if(file[i].isFile()){
				File targetFile=new File(targetDir.getAbsolutePath()+File.separator+file[i].getName());
				MyThread t=threads[n++ % 10];
				t.set(file[i], targetFile);
				t.start();
				t.join();
				threads[n%10]=new MyThread();
			}
			if(file[i].isDirectory()){
				String dir2=targetDir.getAbsolutePath()+File.separator+file[i].getName();
				copyDirectionry(file[i], new File(dir2));
			}
		}
	}
	
}
class MyThread extends Thread{
	private File src;
	private File desc;
	public MyThread() {
	}
	public void set(File src,File desc){
		this.src=src;
		this.desc=desc;
	}
	@Override
	public void run() {
		try{
			copyFile(src,desc);	
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void copyFile(File src, File desc) throws IOException{
		if(!desc.exists()){
			desc.createNewFile();
		}else if(!src.exists()){
			src.createNewFile();
		}
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try{
			FileInputStream fis=new FileInputStream(src);
			FileOutputStream fos=new FileOutputStream(desc);
			bis=new BufferedInputStream(fis);
			bos=new BufferedOutputStream(fos);
			int b=-1;
			while((b=bis.read())!=-1){
				bos.write(b);
			}
		} finally {
			if(bis!=null){
				bis.close();
			}
			if(bos!=null){
				bos.flush();
				bos.close();
			}
		}
	}
}