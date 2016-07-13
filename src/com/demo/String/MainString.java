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
	}

}
