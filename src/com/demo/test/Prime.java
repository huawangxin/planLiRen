package com.demo.test;

import java.util.Scanner;

/**
 * 判断是否为质数
 * 
 * @author huawangxin
 *
 */
public class Prime {

	public static boolean isPrime(int str){
		if(str<2){
//			System.exit(0);
			return false;
		}
		int sum=0;
		for (int i = 1; i <=str; i++) {
			if(str%i==0){
				sum++;
			}
		}
		if(sum==2){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.println("请输入待判断数字");
			int str=scanner.nextInt();
			if(isPrime(str)){
				System.out.println(str+"是质数");
			}else {
				System.out.println(str+"不是质数");
			}
		}
	}

}
