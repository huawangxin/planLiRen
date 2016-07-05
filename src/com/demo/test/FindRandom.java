package com.demo.test;

/**
 * 有1~100共一百个自然数，已随机放入一个有98个元素的数组a[98]。
 * 找出没有被放入数组的那2个数打印出来。
 * 【程序不用实现自然数随机放入数组的过程】
 * 
 * @author huawangxin
 *
 */
public class FindRandom {

	public static void main(String[] args) {
		int[] b=new int[98];//存入98个随机的1~100之间的自然数
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
