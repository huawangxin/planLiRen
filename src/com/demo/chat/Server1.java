package com.demo.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 从服务器写入个字符，在写入本地控制台
 * 
 * @author huawangxin
 *
 */
public class Server1 {

	public static void main(String[] args) throws IOException{
		ServerSocket ss=new ServerSocket(8000);
		Socket s=ss.accept();
		OutputStream out=s.getOutputStream();
		out.write("从服务器读取几个字符!\n".getBytes());
		out.flush();
		out.close();
	}

}
