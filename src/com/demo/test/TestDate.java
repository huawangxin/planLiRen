package com.demo.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		//将date类型转换为 自定义类型
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		System.out.println(time);
		//将自定义日期转换为 date类型
		try {
			Date date1=format.parse(time);
			System.out.println(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
