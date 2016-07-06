package com.demo.test;

/**
 * 5个人坐一起，第5个人比第4个大2岁，第4个人比第3个大2岁，。。。
 * 第2个人比第1个大2岁，第一个人10岁，问第5个人岁数？
 * 
 * 递归算法实现
 * @author huawangxin
 *
 */
public class Recursive {
	static int sum=0;
	/**
	 * 
	 * @param m 第一个人的岁数
	 * @param n 第n个人
	 * @return 第n个人的岁数
	 */
	public static int getAge(int n,int m){
		if(n==1){
			return sum;
		}else if(n>1){
			sum+=2;
			n--;
			getAge(n, m);
		}else if(n<1){
			return -1;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int m=10,n=5;
		sum=m;
		System.out.println(getAge(n, m));
	}

}
