package com.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 题目：有两个List<Integer>，
 * 写一个方法要求合并这两个集合，不能有重复的，不能用集合的sort等方法。
 * 要求中间数字最大，两边主键减少例如(m是集合的size)
 * (get(0)<get(m-1),get(1)<get(m-2))
 * 
 * @author huawangxin
 *
 */
public class TestSort {

	public static void main(String[] args) {
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(7);
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(5);
		list2.add(2);
		list2.add(6);
		list2.add(4);
		
		TreeSet<Integer> set=new TreeSet<Integer>(list1);
		set.addAll(list2);
		List<Integer> ss=new ArrayList<Integer>(set);
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<ss.size();i=i+2){
			list.add(ss.get(i));
		}
		for(int i=(ss.size())/2*2-1;i>0;i=i-2){
			list.add(ss.get(i));
		}
		System.out.println(list);
	}

}
