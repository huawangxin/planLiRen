package com.demo.test;

/**
 * a.b.c为3个整型变量，在不引入第4个变量的前提下写一个算法实现
 * a=b,b=c,c=a
 * 
 * @author huawangxin
 *
 */
public class Test0705001 {

	public static void main(String[] args) {
		int a=1;
		int b=20;
		int c=300;
		a=b-a;
		b=b-a;
		a=a+b;
		b=c-b;
		c=c-b;
		b=c+b;
		System.out.println("a:"+a+",b:"+b+",c:"+c);
	}

}
