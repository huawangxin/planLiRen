package com.demo.test;

/**
 * a.b.cΪ3�����ͱ������ڲ������4��������ǰ����дһ���㷨ʵ��
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
