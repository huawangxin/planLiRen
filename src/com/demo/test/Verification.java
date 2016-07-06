package com.demo.test;

import java.util.Arrays;

/**
 * 生成一个六位数的验证码
 * 大小写字母、数字
 * 
 * @author huawangxin
 *
 */
public class Verification {

	public static void main(String[] args) {
		String[] letters={"A","B","C","D","a","b","c","d","1","2","3"};
		boolean[] flags=new boolean[letters.length];
		String[] chs=new String[6];
		for(int i=0;i<chs.length;i++){
			int index;
			do{
				index=(int)(Math.random()*(letters.length));
			}while(flags[index]);
			chs[i]=letters[index];
			flags[index]=true;
		}
		String code=Arrays.toString(chs);
		System.out.println(code);
	}

}
