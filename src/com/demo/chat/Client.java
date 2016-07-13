package com.demo.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 聊天功能【客户端】
 * 
 * @author huawangxin
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		Client client=new Client();
		client.open();
	}

	private void open() throws IOException{
		Socket s=new Socket("localhost", 8000);
		InputStream in=s.getInputStream();
		OutputStream out=s.getOutputStream();
		new Reader(out).start();
		new Writer(in).start();
	}

}
