package com.demo.test;

/**
 * 公鸡3元/只 母鸡5元/只 小鸡1元/3只
 * 
 * 百钱百买鸡
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
						System.out.println("公鸡:"+gong+",母鸡:"+mu+",小鸡："+xiao);
					}
				}
			}
		}
		if(sum>0){
			System.out.println("买的方式有："+sum+"种");
		}else{
			System.out.println("查找不到合理的购买方式");
		}
	}

}
