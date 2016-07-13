package com.demo.Run;
/**
 * �ֱ���java�ж��̵߳����ַ���ʵ�֣�����ַ�����Hello����Ҫ��ÿ���һ�����һ����ĸ��
 * 
 * @author huawangxin
 *
 */
public class TestRun {

	public static void main(String[] args) {
		TestThread1 tt1=new TestThread1();
		tt1.start();
		Thread tt2=new Thread(new TestThread2());
		tt2.start();
	}
}
class TestThread1 extends Thread {
	@Override
	public void run() {
		char[] str={'H','e','l','l','o'};
		try{
			for(int i=0;i<str.length;i++){
				System.out.print(str[i]);
				sleep(1000);
			}
			System.out.println();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
class TestThread2 implements Runnable {
	@Override
	public void run() {
		char[] str={'H','e','l','l','o'};
		try{
			for(int i=0;i<str.length;i++){
				System.out.print(str[i]);
				Thread.sleep(1000);//Runnable�ӿ�����sleep������ֻ�ܵ���thread�еĸ÷�����
			}
			System.out.println();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}