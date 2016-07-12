package com.demo.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map集合是否包含某元素
 * 
 * @author huawangxin
 *
 */
public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("11", "1");
		map.put("22", "1");
		map.put("33", "1");
		map.put("44", "1");
		map.put("55", "1");
		map.put("66", "1");
		String str="11";
		if(map.containsKey(str)){
			System.out.println(map.get(str));
		}else{
			System.out.println("不存在"+str );
		}
	}

}
