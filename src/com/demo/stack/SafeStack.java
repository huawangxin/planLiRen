package com.demo.stack;

public class SafeStack implements StackInterface{
	private int top=0;
	private int[] values=new int[20];
	private boolean dataAvailable =false;
	public void push(int n){
		synchronized (this) {
			while(dataAvailable){
				try{
					wait();
				}catch (InterruptedException e){
					
				}
			}
			values[top]=n;
			System.out.println("ѹ������"+n+"����1��ɡ�");
			top++;
			dataAvailable=true;
			notifyAll();
			System.out.println("ѹ���������");
		}
	}
	public int[] pop(){
		synchronized (this) {
			while(!dataAvailable){
				try{
					wait();
				}catch(InterruptedException e){
					
				}
			}
			System.out.println("����");
			top--;
			int[] test={values[top],top};
			dataAvailable=false;
			//�������ڵȴ�ѹ�����ݵ��߳�
			notifyAll();
			return test;
		}
	}
	
}
