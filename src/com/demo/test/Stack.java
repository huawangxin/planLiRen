package com.demo.test;

import java.util.Arrays;

public class Stack {

	private Object[] data;
	private int size=0;
	
	public Stack(){
		data=new Object[0];
	}
	
	//ÅÐ¶ÏÕ»ÊÇ·ñÂú
	public boolean isFull() {
		return data.length==size||(data.length==0 && size==0);
	}
	
	//ÅÐ¶ÏÕ»ÊÇ·ñempty
	public boolean isEmpty() {
		return size==0;
	}

	//Êý×éÀ©ÈÝ
	public void increData(){
		data=Arrays.copyOf(data, data.length+10);
	}
	
	//ÈëÕ»
	public void push(Object obj){
		if(isFull()){
			increData();
		}
		size++;
		data[size-1]=obj;
	}
	
	//³öÕ»
	public Object pop(){
		Object o=data[size-1];
		data[size-1]=null;
		size--;
		return o;
	}
	
	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push(1);
		stack.push("123");
		Object o=stack.pop();
		System.out.println(o);
		o=stack.pop();
		System.out.println(o);
	}

	

}
