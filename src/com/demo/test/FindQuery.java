package com.demo.test;

/**
 * ��1��2��2��3,4��5������
 * Ҫ��4�����ڵ���λ��3��5��������
 * ���ݹ��㷨��
 * @author huawangxin
 *	���� n!/(n-m)!
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
                char temp=ss[j];//����ǰ׺,ʹ֮������һ��ǰ׺  
                ss[j]=ss[i];  
                ss[i]=temp;  
                permutation(ss,i+1);  
                temp=ss[j]; //��ǰ׺������,��������һ����ǰ׺����.  
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
