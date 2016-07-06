package com.demo.test;

/**
 * 顺序查找：适合于存储结构为顺序存储或链接存储的线性表
 * 
 * @author huawangxin
 *
 */
public class SearchSequel {

	/**
	 * 在s[0]~s[n-1]中顺序查找关键字为key的记录
	 * 
	 * @param s
	 * @param key
	 * @return 成功时返回该记录的下标序号；失败时返回-1
	 */
	public int sequelSearch(String[] s,String key){
		int i=0;
		while(i<s.length && s[i]!=key){
			i++;
			if(s[i]==key){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String[] strs={"a","b","c"};
		System.out.println(new SearchSequel().sequelSearch(strs, "b"));
	}

}
