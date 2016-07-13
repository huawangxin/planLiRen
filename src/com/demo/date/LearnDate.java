package com.demo.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date�ĳ��÷���С��
 *
 * @author huawangxin
 * 
 */
public class LearnDate {
    public static void main(String[] args){
        
        Date cdate = new Date();
        System.err.println("��ǰʱ��: " + cdate);
        
        //������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�����
        long dddat = cdate.getTime();
        Date ddate = new Date(dddat);
        System.err.println("��1970��1��1�� 00:00:00�ĺ�����: " + dddat);
        System.err.println("���췽��ʹ�ú��ʱ��: " + ddate);
        
        //���ô�Date�����Ա�ʾ1970��1��1�� 00:00:00 GMT �Ժ� time �����ʱ���
        Date sflag = new Date();
        sflag.setTime(dddat);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println(sdf.format(sflag));
        
        //Date����ıȽ�before(),after(),equals(),compareTo()
        try{
            String startTime = "2012-9-25 12:12:12";
            String endTime = "2012-10-25 12:12:12";
            SimpleDateFormat se = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = se.parse(startTime);
            Date endDate = se.parse(endTime);
            if(startDate.before(endDate)){
                System.err.println("��ʼʱ��С�ڽ���ʱ��");
            }else if(startDate.after(endDate)){
                System.err.println("��ʼʱ����ڽ���ʱ��");
            }else if(startDate.equals(endDate)){
                System.err.println("��ʼʱ����ڽ���ʱ��");
            }
            /*
             * startDate > endDate ����1
             * startDate == endDate ����0
             * startDate < endDate ����-1
             */
            int flag = startDate.compareTo(endDate);
            System.err.println("flag = " + flag);
            
            //toString():�����Fri Oct 12 10:58:01 CST 2012
            Date cc = new Date();
            String ccc = cc.toString();
            System.err.println("����ת��ΪString��" + ccc);
        }catch(Exception e){}
    }
}
