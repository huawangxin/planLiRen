package com.demo.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 正则表达式 过滤器
 * 
 * @author huawangxin
 *
 */
public class StringFilter {

	public static String StringFilter(String str) throws PatternSyntaxException{
		String regEx="[=\\\\<>]";
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(str);
		return m.replaceAll("").trim();
	}
	public static void main(String[] args) {
		String str="<<山东啊udssdsd速度圣斗士！@#￥%……>=";
		System.out.println(str);
		System.out.println(StringFilter(str));
	}

}
