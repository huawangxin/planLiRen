package com.demo.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �ӷ�����д����ַ�����д�뱾�ؿ���̨
 * 
 * @author huawangxin
 *
 */
public class Server1 {

	public static void main(String[] args) throws IOException{
		ServerSocket ss=new ServerSocket(8000);
		Socket s=ss.accept();
		OutputStream out=s.getOutputStream();
		out.write("�ӷ�������ȡ�����ַ�!\n".getBytes());
		out.flush();
		out.close();
	}

}
