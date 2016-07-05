package com.demo.test;

/**
 * 递归：指函数或程序在运行过程中直接或间接调用自身的现象。
 * 解决的问题：
 * 			1，数据的定义按递归定义；(斐波那契函数)
 * 			2，数据的结构形式按递归定义；(树的遍历，图的搜索)
 * 			3，问题解法按递归算法实现。(回溯)
 * 
 * @author huawangxin
 *
 */
public class TestRecursive {
	
	/**
	 * 计算二进制中1的个数
	 * 
	 * @param num 数值
	 * @return 计算出来1的总个数
	 */
	public static int getBinary(int num){
		if(num==1){
			return 1;
		}else if(0==num%2){
			return getBinary(num/2);
		}else {
			return getBinary(num/2)+1;
		}
	}
	
	public static void main(String[] args) {
		int  a=getBinary(999);
		System.out.println(a);
	}

}
