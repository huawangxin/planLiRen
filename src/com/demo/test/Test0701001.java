package com.demo.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��дһ�������г�����ʾ���û�����2��������Ȼ�������2������֮���ܱ�5���������������ĺ͡�
 * 
 * @author huawangxin
 *
 */
public class Test0701001 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] nums=new int[2];
		System.out.println("������һ��������");
		nums[0]=sc.nextInt();
		System.out.println("��������һ��������");
		nums[1]=sc.nextInt();
		Arrays.sort(nums);
		int sum=0;
		for(int begin=nums[0]+1;begin<nums[1];begin++){
			if(begin%5==0){
				sum+=begin;
			}
		}
		System.out.println("�ܺͣ�"+sum);
	}

}
