package com.demo.error;

import java.util.Scanner;

public class MainError {

	public static void main(String[] args) throws InvalidScoreException {
		System.out.println("������ɼ���");
		Scanner s=new Scanner(System.in);
		try{
			int score=Integer.parseInt(s.next());
			if(score<0||score>100){
				throw new InvalidScoreException("����Ҫ��1~100֮��");
			}
		} catch (NumberFormatException e){
			throw new InvalidScoreException("����Ҫ��������");
		}
	}

}
