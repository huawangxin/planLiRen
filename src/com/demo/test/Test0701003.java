package com.demo.test;

/**
 * �������
 * ��ע������10��������Σ���Ҫ��������
 * @author huawangxin
 *
 */
public class Test0701003 {
	public static void main(String[] args) {
		int n=10;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n-i;j++){
				System.out.print(" ");
			}
			//��ӡ�ո������ַ����ӵ�1�п�	ʼ�����ӡ
			for(int j=1;j<=i;j++){
				System.out.print(num(i,j)+" ");
			}
			System.out.println("");
		}
	}

	private static int num(int x, int y) {
		if(y==1||y==x){
			return 1;
		}
		int c=num(x-1, y-1)+num(x-1, y);
		return c;
	}

}
