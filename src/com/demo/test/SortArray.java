package com.demo.test;

/**
 * 1~100����a[99]�������У����û������������֡�
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
				System.out.println("δ�������������Ϊ:"+(i+1));
			}
		}
	}

}
