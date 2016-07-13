package com.demo.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 * 
 * @author huawangxin
 *
 */
public class ToDate {

	public static void main(String[] args) {
		//获取系统当前时间
		Date date=new Date();
		Calendar c=Calendar.getInstance();
		//将日期转换成想要的格式 如：2008-04-01。。。
		
	}
	//将日期转换为指定格式
	public static String getFormatDate(Date date){
		DateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=fmt.format(date);
		return str;
	}
	//计算任意两个日期之间的天数
	//1
	public static double getDays(Calendar c1,Calendar c2){
		Date date1=c1.getTime();
		Date date2=c2.getTime();
		return getDays(date1, date2);
	}
	private static double getDays(Date date1, Date date2) {
		long time1=date1.getTime();
		long time2=date2.getTime();
		double d=Math.abs((time1-time2)/1000d/60/60/24);
		return d;
	}
	//2
	public static double getDays(String str1,String str2) throws ParseException{
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date1=format.parse(str1);
		Date date2=format.parse(str2);
		return getDays(date1, date2);
	}
}
