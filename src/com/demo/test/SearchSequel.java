package com.demo.test;

/**
 * ˳����ң��ʺ��ڴ洢�ṹΪ˳��洢�����Ӵ洢�����Ա�
 * 
 * @author huawangxin
 *
 */
public class SearchSequel {

	/**
	 * ��s[0]~s[n-1]��˳����ҹؼ���Ϊkey�ļ�¼
	 * 
	 * @param s
	 * @param key
	 * @return �ɹ�ʱ���ظü�¼���±���ţ�ʧ��ʱ����-1
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
