package com.demo.test;

/**
 * ����3Ԫ/ֻ ĸ��5Ԫ/ֻ С��1Ԫ/3ֻ
 * 
 * ��Ǯ����
 * @author huawangxin
 *
 */
public class Chickens {

	public static void main(String[] args) {
		int sum=0;
		for(int gong=0;gong<=100;gong++){
			for(int mu=0;mu<=100/5;mu++){
				for(int xiao=0;xiao<100*3;xiao+=3){
					if((gong+mu+xiao)==100
							&&(gong*3+mu*5+xiao/3)==100){
						sum++;
						System.out.println("����:"+gong+",ĸ��:"+mu+",С����"+xiao);
					}
				}
			}
		}
		if(sum>0){
			System.out.println("��ķ�ʽ�У�"+sum+"��");
		}else{
			System.out.println("���Ҳ�������Ĺ���ʽ");
		}
	}

}
