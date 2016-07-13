package com.demo.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ������[5,1,2,-5,...]�������ÿ�����ֳ��ֵ�Ƶ����(��������һ��)
 * 
 * @author huawangxin
 *
 */
public class CountArray {

	public static void main(String[] args) {
		int[] arr={5,1,3,5,7,5,8,1,1,1,1,2};
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(Integer i:arr){
			Integer key=Math.abs(i);
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}
		Set<Integer> keys=map.keySet();
		for(Integer key:keys){
			System.out.println(key+"����"+map.get(key)+"��");
		}
	}
	
	
}
