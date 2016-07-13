package com.demo.error;

import java.util.Scanner;

public class MainError {

	public static void main(String[] args) throws InvalidScoreException {
		System.out.println("请输入成绩：");
		Scanner s=new Scanner(System.in);
		try{
			int score=Integer.parseInt(s.next());
			if(score<0||score>100){
				throw new InvalidScoreException("分数要在1~100之间");
			}
		} catch (NumberFormatException e){
			throw new InvalidScoreException("分数要求是数字");
		}
	}

}
