package com.demo.test;

import java.util.Arrays;

/**
 * 排序算法集合
 * 
 * 
 * @author huawangxin
 *
 */
public class TestSort {

	/**
	 * 快速排序法
	 * @param number
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] a,int start,int end){
		int i, j;  
        i = start;  
        j = end;  
        if ((a == null) || (a.length == 0)){
        	return;
        }
        while (i < j) {//查找基准点下标  
            while (i < j && a[i] <= a[j]){
            	// 以数组start下标的数据为key，右侧扫描  
                j--; 
            }
            if (i < j) { // 右侧扫描，找出第一个比key小的，交换位置  
                int temp = a[i];  
                a[i] = a[j];  
                a[j] = temp;  
            }  
            while (i < j && a[i] < a[j]){
            	// 左侧扫描（此时a[j]中存储着key值）  
                i++;  
            }
            if (i < j) { // 找出第一个比key大的，交换位置  
                int temp = a[i];  
                a[i] = a[j];  
                a[j] = temp;  
            }  
        }
        if (i - start > 1) { // 递归调用，把key前面的完成排序  
            quickSort(a, 0, i - 1);  
        }
        if (end - j > 1) {
            quickSort(a, j + 1, end); // 递归调用，把key后面的完成排序  
        }
	}
	
	/**
	 * 选择排序
	 * @param number
	 */
	public static void selectSort(int[] number){
		for(int i=0;i<number.length-1;i++){
			int m=i;
			for(int j=i+1;j<number.length;j++){
				if(number[j]<number[m]){
					m=j;
				}
				if(i!=m){
					swap(number,i,m);
				}
			}
		}
	}
	
	/**
	 * 冒泡排序
	 * @param number
	 */
	public static void BubbleSort(int[] number){
		for(int i=0;i<number.length-1;i++){
			for(int j=0;j<number.length-i-1;j++){
				if(number[j]>number[j+1]){
					swap(number, j, j+1);
				}
			}
			System.out.println(Arrays.toString(number));
		}
	}
	
	/**
	 * 交换数组中的索引为i,j的元素
	 * @param number
	 * @param i
	 * @param m
	 */
	private static void swap(int[] number, int i, int m) {
		int t;
		t=number[i];
		number[i]=number[m];
		number[m]=t;
	}

	public static void main(String[] args) {
		int[]  num=new int[8];
		for(int i=0;i<num.length;i++){
			num[i]=(int)(Math.random()*100)+1;
		}
		//selectSort(num);
//		BubbleSort(num);
		quickSort(num,0,num.length-1);
		for(int i=0;i<num.length;i++){
			System.out.println(num[i]);
		}
	}

}
