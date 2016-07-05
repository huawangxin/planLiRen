package com.demo.test;

import java.util.Arrays;

/**
 * 二分法 查找相同数据
 * 
 * @author Administrator
 *
 */
public class SearchDemo {

	private static final int size=1000;
	public static void main(String[] args) {
		int[] data=new int[size];
		for(int k=0;k<data.length;k++){
			data[k]=k+1;
		}
		data[999]=567;
		result(data);
	}
	/**
	 * 
	 * @param data
	 */
	private static void result(int[] data) {
		Arrays.sort(data);
		for(int i=0;i<data.length;i++){
			int target=data[i];
			data[i]=0;
			int result =binaryFind(data,target);
			if(result != -1){
				System.out.println("相同数字为："+result);
				break;
			}
		}
	}
	/**
	 * 二分搜索算法
	 * @param data 数据集合
	 * @param target 搜索的数据
	 * @return 返回找到数据的位置，返回-1 表示没有找到。
	 */
	private static int binaryFind(int[] data, int target) {
		int start=0;
		int end=data.length-1;
		while(start<=end){
			int middleIndex=(start+end)/2;
			if(target==data[middleIndex]){
				return middleIndex;
			}
			if(target>=data[middleIndex]){
				start=middleIndex+1;
			}else {
				end=middleIndex-1;
			}
		}
		return -1;
	}

}
