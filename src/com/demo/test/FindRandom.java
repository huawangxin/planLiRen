package com.demo.test;

/**
 * ��1~100��һ�ٸ���Ȼ�������������һ����98��Ԫ�ص�����a[98]��
 * �ҳ�û�б������������2������ӡ������
 * ��������ʵ����Ȼ�������������Ĺ��̡�
 * 
 * @author huawangxin
 *
 */
public class FindRandom {

	public static void main(String[] args) {
		int[] b=new int[98];//����98�������1~100֮�����Ȼ��
		int[] a=new int[100];
		for(int t:b){
			a[t-1]=t;
		}
		for(int t=0;t<a.length;t++){
			if(a[t]==0){
				System.out.println(t+1);
			}
		}
	}

}
