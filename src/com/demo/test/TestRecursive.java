package com.demo.test;

/**
 * �ݹ飺ָ��������������й�����ֱ�ӻ��ӵ������������
 * ��������⣺
 * 			1�����ݵĶ��尴�ݹ鶨�壻(쳲���������)
 * 			2�����ݵĽṹ��ʽ���ݹ鶨�壻(���ı�����ͼ������)
 * 			3������ⷨ���ݹ��㷨ʵ�֡�(����)
 * 
 * @author huawangxin
 *
 */
public class TestRecursive {
	
	/**
	 * �����������1�ĸ���
	 * 
	 * @param num ��ֵ
	 * @return �������1���ܸ���
	 */
	public static int getBinary(int num){
		if(num==1){
			return 1;
		}else if(0==num%2){
			return getBinary(num/2);
		}else {
			return getBinary(num/2)+1;
		}
	}
	
	public static void main(String[] args) {
		int  a=getBinary(999);
		System.out.println(a);
	}

}
