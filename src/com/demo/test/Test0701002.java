package com.demo.test;

import java.util.Scanner;

/**
 * �����г������û������û������룬����ȷ����ʾ��¼�ɹ�����������ʾ��¼ʧ�ܣ����û��������롣
 * �������3��֤ʧ�ܣ���������ֹ����
 * 
 * @author huawangxin
 *
 */
public class Test0701002 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=0;
		while(true){
			System.out.println("�������˺ţ�");
			String name=sc.nextLine();
			System.out.println("���������룺");
			String pwd=sc.nextLine();
			if("admin".equals(name)&&"admin".equals(pwd)){
				System.out.println("��¼�ɹ�");
				break;
			}else{
				count++;
				if(count<3){
					System.out.println("��¼ʧ�ܣ�����������");
				}else{
					System.out.println("��¼�������࣬��֤ʧ�ܡ�");
					break;
				}
			}
		}
	}

}
