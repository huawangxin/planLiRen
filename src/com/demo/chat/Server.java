package com.demo.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ���칦�ܡ��������ˡ�	
 * 
 * @author huawangxin
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		Server server=new Server();
		server.start();
	}
	
	public void start() throws IOException {
		ServerSocket ss=new ServerSocket(8000);
		System.out.println("�ȴ��ͻ�������...");
		Socket s=ss.accept();
		System.out.println("�ͻ������ӳɹ���"+s.getInetAddress());
		InputStream in=s.getInputStream();
		OutputStream out=s.getOutputStream();
		Reader r=new Reader(out);
		r.start();
		Writer w=new Writer(in);
		w.start();
	}
}
class Reader extends Thread{
	OutputStream out;
	public Reader(OutputStream out) {
		this.out=out;
		setDaemon(true);//setDaemon���߳�����Ϊ��̨����
	}
	@Override
	public void run() {
		Scanner s=new Scanner(System.in);
		try{
			while(true){
				String str=s.nextLine();
				out.write(str.getBytes());
				out.write('\n');
				out.flush();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
class Writer extends Thread{
	InputStream in;
	public Writer(InputStream in) {
		this.in=in;
		setDaemon(true);
	}
	@Override
	public void run() {
		try {
			int b;
			while((b=in.read())!=-1){
				System.out.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}