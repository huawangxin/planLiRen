package com.demo.String;

import java.util.Arrays;

/**
 * ��ȡ�ַ����е�ĳЩ���ݣ������ض�˳�����С�
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
		System.out.println(reverseSting("����й���boy!"));
	}

	/**
	 * ��ת�ַ�������
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
}
