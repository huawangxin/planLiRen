package com.demo.test;

/**
 * 用1，2，2，3,4，5，排列
 * 要求4不能在第三位，3，5不能相连
 * 【递归算法】
 * @author huawangxin
 *	总数 n!/(n-m)!
 */
public class FindQuery {
	private static String temp="";
	public static void permutation(char[]ss,int i){  
        if(ss==null||i<0 ||i>ss.length){
            return;  
        }  
        if(i==ss.length){
        	temp=new String(ss); 
        	if(temp.indexOf("4")!=2&&temp.indexOf("35")==-1&&temp.indexOf("53")==-1){
                System.out.println(temp);
        	}
        }else{
            for(int j=i;j<ss.length;j++){
                char temp=ss[j];//交换前缀,使之产生下一个前缀  
                ss[j]=ss[i];  
                ss[i]=temp;  
                permutation(ss,i+1);  
                temp=ss[j]; //将前缀换回来,继续做上一个的前缀排列.  
                ss[j]=ss[i];  
                ss[i]=temp;  
            }
        }
    }
    public static void main(String args[]){
        char []ss={'1','2','2','3','4','5'};  
        permutation(ss,0);  
    }

}
