package com.demo.test;

/**
 * 杨辉三角
 * 备注：超过10的数会变形，需要后期完善
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
			//打印空格后面的字符，从第1列开	始往后打印
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
