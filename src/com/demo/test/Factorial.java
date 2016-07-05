package com.demo.test;

/**
 * n!µÄËã·¨
 * 
 * @author huawangxin
 *
 */
public class Factorial {

	public static long doFactorial(long n){
		if(n<1){
			System.out.println("ERROR");
			return 0;
		}else if(n==1||n==2){
			return n;
		}else{
			return n*doFactorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		long a=doFactorial(5);
		System.out.println(a);
	}

}
