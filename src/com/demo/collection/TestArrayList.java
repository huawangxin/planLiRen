package com.demo.collection;

import java.util.ArrayList;

/**
 * 测试arraylist集合
 * 取出所有数据
 * 
 * @author huawangxin
 *
 */
public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		for(int i=list.size()-1;i>=0;i--){
			list.remove(i);
			System.out.println(list);
		}
		System.out.println("结果："+list);
	}

}
