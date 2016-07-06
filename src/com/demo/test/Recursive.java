package com.demo.test;

/**
 * 5������һ�𣬵�5���˱ȵ�4����2�꣬��4���˱ȵ�3����2�꣬������
 * ��2���˱ȵ�1����2�꣬��һ����10�꣬�ʵ�5����������
 * 
 * �ݹ��㷨ʵ��
 * @author huawangxin
 *
 */
public class Recursive {
	static int sum=0;
	/**
	 * 
	 * @param m ��һ���˵�����
	 * @param n ��n����
	 * @return ��n���˵�����
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
