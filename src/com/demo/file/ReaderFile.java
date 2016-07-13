package com.demo.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;



/**
 * ���ļ��ж�ȡ�ļ����ݣ�����ѡ���Ե��������һ���ļ��С�
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
	 * ���ʵ���
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
	 * ������תΪ�ַ���
	 */
	public static String toString(String[] ary){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ary.length;i++){
			sb.append(ary[i]);
		}
		return sb.toString();
	}
}
