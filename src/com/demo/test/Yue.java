package com.demo.test;

/**
 * 本质：约瑟夫环的java实现
 * 设n个人围成一圈，从第一个开始报数，第m个人出列，下一个人开始从1报数。。。反复到所有人出列，
 * 设n个人的编号分别为1，2，。。。，n，求出列顺序
 * 
 * @author huawangxin
 *
 */

import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
  
public class Yue {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("请输入总人数：");  
        int totalNum = scanner.nextInt();  
        System.out.print("请输入报数的大小：");  
        int cycleNum = scanner.nextInt();  
        yuesefu(totalNum, cycleNum);  
    }  
  
   public static void yuesefu(int totalNum, int countNum) {  
        // 初始化人数  
        List<Integer> start = new ArrayList<Integer>();  
        for (int i = 1; i <= totalNum; i++) {  
            start.add(i);  
        }  
        //从第K个开始计数  
        int k = 0;  
        while (start.size() >0) {  
            k = k + countNum;  
            //第m人的索引位置  
            k = k % (start.size()) - 1;  
           // 判断是否到队尾  
            if (k < 0) {  
                System.out.println(start.get(start.size()-1));  
                start.remove(start.size() - 1);  
                k = 0;  
            } else {  
                System.out.println(start.get(k));  
                start.remove(k);  
            }  
        }  
    }  
}
