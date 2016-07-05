package com.demo.test;

import java.util.Arrays;

/**
 * �����㷨����
 * 
 * 
 * @author huawangxin
 *
 */
public class TestSort {

	/**
	 * ��������
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
        while (i < j) {//���һ�׼���±�  
            while (i < j && a[i] <= a[j]){
            	// ������start�±������Ϊkey���Ҳ�ɨ��  
                j--; 
            }
            if (i < j) { // �Ҳ�ɨ�裬�ҳ���һ����keyС�ģ�����λ��  
                int temp = a[i];  
                a[i] = a[j];  
                a[j] = temp;  
            }  
            while (i < j && a[i] < a[j]){
            	// ���ɨ�裨��ʱa[j]�д洢��keyֵ��  
                i++;  
            }
            if (i < j) { // �ҳ���һ����key��ģ�����λ��  
                int temp = a[i];  
                a[i] = a[j];  
                a[j] = temp;  
            }  
        }
        if (i - start > 1) { // �ݹ���ã���keyǰ����������  
            quickSort(a, 0, i - 1);  
        }
        if (end - j > 1) {
            quickSort(a, j + 1, end); // �ݹ���ã���key������������  
        }
	}
	
	/**
	 * ѡ������
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
	 * ð������
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
	 * ���������е�����Ϊi,j��Ԫ��
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
