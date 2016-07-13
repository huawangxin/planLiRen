package com.demo.chat;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 
 * 
 * @author huawangxin
 *
 */
public class Client1 {

	public static void main(String[] args) throws IOException{
		Socket s=new Socket("localhost", 8000);
		InputStream in=s.getInputStream();
		int b;
		while((b=in.read())!=-1){
			System.out.write(b);
		}
	}

}
