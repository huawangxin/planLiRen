package com.demo.test;

/**
 * ��һ�������32λ���ͱ���  value ��ֵ�� ��32��Ԫ�ص�����a[32]��Ӧֵ
 * 
 * @author huawangxin
 *
 */
public class Foo {

	
	public static void main(String[] args) {
		//���������
		int random=(int)(Math.random()*Integer.MAX_VALUE+1);
		//ת�ɶ������ַ���
		String str=Integer.toBinaryString(random);
		//ת���ɶ�����ʱǰ��ȱ��λ����
		if(str.length()<32){
			for(int j=0;j<32-str.length();j++){
				str="0"+str;
			}
		}
		//�����鸳ֵ
		int[] a=new int[32];
		for(int i=0;i<str.length();i++){
			a[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
			System.out.println("s["+i+"]="+a[i]);
		}
	}

}
