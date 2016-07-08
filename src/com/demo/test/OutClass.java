package com.demo.test;

public class OutClass {

	class InterClass{
		public InterClass() {
			System.out.println("interclass create");
		}
	}
	
	public OutClass() {
		InterClass interClass=new InterClass();
		System.out.println("outclass create");
	}
	
	public static void main(String[] args) {
		OutClass outClass=new OutClass();
	}

}
