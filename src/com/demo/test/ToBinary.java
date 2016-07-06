package com.demo.test;

/**
 * 将一个整数十进制转化为二进制数(不使用java类库)
 * 
 * @author Administrator
 *
 */
public class ToBinary {

	public static void main(String[] args) {
		System.out.println("转换为二进制为："+hexConvert(0));
	}

	/**
	 * 10进制转2进制【目前尽限于 正整数】
	 * @param i
	 * @return
	 */
	private static String hexConvert(int i) {
		String sum="";
		do {
			if(i%2==0){
				sum=0+sum;
			}else if(i%2!=0){
				sum=1+sum;
			}
			i=i/2;
		} while (i!=0);
		return sum;
	}

	/**
	 * 
	 */
	private static void test(){
	    System.out.println("十转二："+Integer.toBinaryString(120));
	    System.out.println("十转八："+Integer.toOctalString(120));
	    System.out.println("十转十六："+Integer.toHexString(120));
	    System.out.println("二转十："+Integer.valueOf("1010",2));
	    System.out.println("八转十："+Integer.valueOf("125",8));
	    System.out.println("十六转十："+Integer.valueOf("ABCDEF",16));
	}
	
}
