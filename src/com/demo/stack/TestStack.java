package com.demo.stack;

/**
 * 生产者和消费者问题
 * 采用Java多线程技术(wait和notify)。
 * 对一个枪膛对象进行操作，其最大容量是20颗子弹。
 * 生产者线程是一个压入线程，它不断向枪膛中压入子弹；
 * 消费者线程是一个射出线程，它不断从枪膛中射出自子弹。
 * 
 * @author huawangxin
 *
 */
public class TestStack {

	public static void main(String[] args) {
		SafeStack s=new SafeStack();
		PushThread r1=new PushThread(s);
		PopThread r2=new PopThread(s);
		PopThread r3=new PopThread(s);
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		Thread t3=new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}

}
