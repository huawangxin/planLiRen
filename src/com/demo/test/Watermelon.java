package com.demo.test;

/**
 * ��1020�����ϣ���һ����һ����������Ժ�ÿ�춼��ʣ�µ�һ���������
 * �ʵڼ������ꡣ
 * 
 * @author huawangxin
 *
 */
public class Watermelon {
	static int sum=0;
	static int i=1;
	/**
	 * n������ ����Ҫ����
	 * @param n ʣ��������
	 * @return ����
	 */
	public static int sellOutWatermelon(int n){
		if(n<=4){
			sum++;
			System.out.println("��"+i+"���������ϡ�");
			return sum;
		}else if(n>4){
			sum++;
			n=n/2-2;
			System.out.println("��"+i+"��ʣ��"+n+"�����ϡ�");
			i++;
			sellOutWatermelon(n);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int n=1001;
		System.out.println(n+" ������ ������Ҫ "+sellOutWatermelon(n)+" ��");
	}

}
