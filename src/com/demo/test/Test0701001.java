package com.demo.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 编写一个命令行程序，提示让用户输入2个整数，然后计算这2个整数之间能被5整除的所有整数的和。
 * 
 * @author huawangxin
 *
 */
public class Test0701001 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] nums=new int[2];
		System.out.println("请输入一个整数：");
		nums[0]=sc.nextInt();
		System.out.println("请再输入一个整数：");
		nums[1]=sc.nextInt();
		Arrays.sort(nums);
		int sum=0;
		for(int begin=nums[0]+1;begin<nums[1];begin++){
			if(begin%5==0){
				sum+=begin;
			}
		}
		System.out.println("总和："+sum);
	}

}
