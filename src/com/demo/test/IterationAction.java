package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * 迭代各类集合
 * 
 * @author huawangxin
 *
 */
public class IterationAction {

	/**
	 * 迭代List
	 */
	public void getList(){
		List<String> names=new ArrayList<String>();
		names.add("a");
		names.add("b");
		for(int i=0;i<names.size();i++){
			String str=names.get(i);
			System.out.println(str);
		}
	}
	
	/**
	 * 迭代Set
	 */
	public void getSet(){
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("b");
		Iterator<String> ite=set.iterator();
		while(ite.hasNext()){
			String egg=ite.next();
			System.out.println(egg);
		}
	}
	
	/**
	 * 迭代map
	 */
	public void getMap(){
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("a", 1);
		map.put("b", 2);
		
		Set<Entry<String,Integer>> entrySet=map.entrySet();
		for(Entry<String,Integer> entry:entrySet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	


}
