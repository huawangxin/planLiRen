package com.demo.test;

/**
 * 1~100放入a[99]个数组中，求出没放入数组的数字。
 * 
 * @author huawwangxin
 *
 */
public class SortArray {

	public static void main(String[] args) {
		int[] b=new int[99];
		for(int i=0;i<99;i++){
			b[i]=i+1;
		}
		int[] a=new int[100];
		for(int c:b){
			a[c-1]=c;
		}
		for(int i=0;i<a.length;i++){
			if(a[i]==0){
				System.out.println("未放入数组的数字为:"+(i+1));
			}
		}
	}

}
