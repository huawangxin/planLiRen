package com.demo.test;

import java.util.Scanner;

/**
 * 命令行程序，让用户输入用户名密码，都正确会显示登录成功，不是则显示登录失败，让用户重新输入。
 * 如果连续3认证失败，则锁定终止程序。
 * 
 * @author huawangxin
 *
 */
public class Test0701002 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=0;
		while(true){
			System.out.println("请输入账号：");
			String name=sc.nextLine();
			System.out.println("请输入密码：");
			String pwd=sc.nextLine();
			if("admin".equals(name)&&"admin".equals(pwd)){
				System.out.println("登录成功");
				break;
			}else{
				count++;
				if(count<3){
					System.out.println("登录失败，请重新输入");
				}else{
					System.out.println("登录次数过多，认证失败。");
					break;
				}
			}
		}
	}

}
