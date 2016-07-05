package com.demo.test;

/**
 * 将一个随机的32位整型变量  value 赋值到 有32个元素的数组a[32]对应值
 * 
 * @author huawangxin
 *
 */
public class Foo {

	
	public static void main(String[] args) {
		//产生随机数
		int random=(int)(Math.random()*Integer.MAX_VALUE+1);
		//转成二进制字符串
		String str=Integer.toBinaryString(random);
		//转换成二进制时前面缺的位补零
		if(str.length()<32){
			for(int j=0;j<32-str.length();j++){
				str="0"+str;
			}
		}
		//给数组赋值
		int[] a=new int[32];
		for(int i=0;i<str.length();i++){
			a[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
			System.out.println("s["+i+"]="+a[i]);
		}
	}

}
