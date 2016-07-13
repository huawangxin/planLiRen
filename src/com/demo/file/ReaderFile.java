package com.demo.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;



/**
 * 从文件中读取文件内容，内容选择性地输出到另一个文件中。
 * 
 * @author huawangxin
 *
 */
public class ReaderFile {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream("a.txt")), "gbk"));
		FileOutputStream fos=new FileOutputStream("b.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos, "gbk");
		PrintWriter out=new PrintWriter(osw);
		String str;
		while((str=in.readLine())!=null){
			str=str.trim();
			if(str.equals("")){
				continue;
			}
			String[] ary=str.split("\\w]]s*");
			ary=f(ary);
			str=toString(ary);
			out.println(str);
		}
		in.close();
		out.flush();
		out.close();
	}
	/*
	 * 单词倒排
	 */
	public static String[] f(String[] ary){
		int n=ary.length;
		String[] ss=new String[n];
		for(int i=0;i<n;i++){
			ss[i]=ary[n-1-i];
		}
		return ss;
	}
	/*
	 * 将数组转为字符串
	 */
	public static String toString(String[] ary){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ary.length;i++){
			sb.append(ary[i]);
		}
		return sb.toString();
	}
}
