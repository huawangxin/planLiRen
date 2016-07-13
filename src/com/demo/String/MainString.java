package com.demo.String;

import java.util.Arrays;

/**
 * 获取字符串中的某些数据，并按特定顺序排列。
 * 
 * @author huawangxin
 *
 */
public class MainString {

	public static void main(String[] args) {
		String str="ABC123DJ8K4HJ5K6N7B";
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c>='0'&&c<='9'){
				stringBuilder.append(c);
			}
		}
		System.out.println(stringBuilder);
		char[] ary=stringBuilder.toString().toCharArray();
		Arrays.sort(ary);
		System.out.println(ary);
		//
		System.out.println(reverseSting("你好中国，boy!"));
	}

	/**
	 * 反转字符串函数
	 * @param str
	 * @return
	 */
	public static String reverseSting(String str){
		//1
		char[] chars=str.toCharArray();
		StringBuilder sb=new StringBuilder();
		for(int i=chars.length-1;i>=0;i--){
			sb.append(chars[i]);
		}
//		2
//		sb=new StringBuilder(str);
//		sb.reverse().toString();
		return sb.toString();
	}
	
	/**
	 * 写一个函数，2个参数，1个字符串，1个字节数，返回截取的字符串(从头开始截取)，要求中文不能出现乱码
	 * 
	 * @return 
	 * 
	 */
	public static String subString(String str,int subBytes){
		int bytes=0;
		for(int i=0;i<str.length();i++){
			if(bytes==subBytes){
				return str.substring(0, 1);
			}
			char c=str.charAt(i);
			if(c<256){
				bytes+=1;
			}else {
				//中文字符大于256
				bytes+=2;
				if(bytes-subBytes==1){
					return str.substring(0,i);
				}
			}
		}
		return str;
	}
	/**
	 * 去掉字符串中所有的 数字
	 * @param str
	 * @return
	 */
	public String deleteDigital (String str){
		return str.replaceAll("\\d+", "");
	}
}
