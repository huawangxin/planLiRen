package com.demo.test;

/**
 * 有1020个西瓜，第一天卖一半多两个，以后每天都是剩下的一半多两个。
 * 问第几天卖完。
 * 
 * @author huawangxin
 *
 */
public class Watermelon {
	static int sum=0;
	static int i=1;
	/**
	 * n个西瓜 卖完要几天
	 * @param n 剩余西瓜数
	 * @return 天数
	 */
	public static int sellOutWatermelon(int n){
		if(n<=4){
			sum++;
			System.out.println("第"+i+"天卖光西瓜。");
			return sum;
		}else if(n>4){
			sum++;
			n=n/2-2;
			System.out.println("第"+i+"天剩余"+n+"个西瓜。");
			i++;
			sellOutWatermelon(n);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int n=1001;
		System.out.println(n+" 个西瓜 卖完需要 "+sellOutWatermelon(n)+" 天");
	}

}
