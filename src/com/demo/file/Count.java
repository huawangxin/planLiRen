package com.demo.file;

import java.io.FileReader;
import java.io.Reader;

/**
 * ͳ�ƹ�����
 * 
 * @author huawangxin
 *
 */
public class Count {

	/**
	 * ����һ���ļ��� �� һ���ַ�����ͳ������ַ���������ļ��г��ֵĴ���
	 * 
	 * @param file
	 * @param find
	 * @return
	 * @throws Exception
	 */
	public int countWords(String  file, String find) throws Exception {
		int count=0;
		Reader in=new FileReader(file);
		int c;
		while((c=in.read())!=-1){
			while((c==find.charAt(0))){
				for(int i=1;i<find.length();i++){
					c=in.read();
					if(c!=find.charAt(i)){
						break;
					}
					if(i==find.length()-1){
						count++;
					}
				}
			}
		}
		return count;
	}
}
