package com.demo.collection;

import java.util.ArrayList;

/**
 * ����arraylist����
 * ȡ����������
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
		System.out.println("�����"+list);
	}

}
