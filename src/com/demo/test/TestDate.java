package com.demo.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		//��date����ת��Ϊ �Զ�������
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		System.out.println(time);
		//���Զ�������ת��Ϊ date����
		try {
			Date date1=format.parse(time);
			System.out.println(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
