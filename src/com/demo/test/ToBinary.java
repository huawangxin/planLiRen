package com.demo.test;

/**
 * ��һ������ʮ����ת��Ϊ��������(��ʹ��java���)
 * 
 * @author Administrator
 *
 */
public class ToBinary {

	public static void main(String[] args) {
		System.out.println("ת��Ϊ������Ϊ��"+hexConvert(0));
	}

	/**
	 * 10����ת2���ơ�Ŀǰ������ ��������
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
	    System.out.println("ʮת����"+Integer.toBinaryString(120));
	    System.out.println("ʮת�ˣ�"+Integer.toOctalString(120));
	    System.out.println("ʮתʮ����"+Integer.toHexString(120));
	    System.out.println("��תʮ��"+Integer.valueOf("1010",2));
	    System.out.println("��תʮ��"+Integer.valueOf("125",8));
	    System.out.println("ʮ��תʮ��"+Integer.valueOf("ABCDEF",16));
	}
	
}
