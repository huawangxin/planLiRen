package com.demo.test;

/**
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不
 * 死，问每个月的兔子总数为多少？
 * 
 * 斐波那契数列，公式：S(n)=S(n-1)+S(n-2)
 * 
 * @author huawangxin
 *
 */
public class CalculateRabbit {

	public static void main(String[] args) {
		int i=0; 
		for(i=1;i<=20;i++)
			System.out.println("第"+i+"个月 兔子对数："+f(i));
	}
	public static int f(int x){ 
		if(x==1 || x==2) 
			return 1; 
		else
			return f(x-1)+f(x-2);
	}

}
