package com.demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar�ĳ��÷����ͳ�������С��
 *
 * @author huawangxin
 * 
 */
public class LearnCalendar {
    
    public static void main(String[] args){
        //���÷���
        param();
        //��������
        method();
    }
    //���÷���
    public static void method(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        //setTime():ʹ�ø�����Date���ô� Calendar ��ʱ��
        c.setTime(date);
        //��ȡCalendar����
        Calendar cm = Calendar.getInstance();
        //getTime():��ȡ��ǰʱ�䣬������new Date();
        Date d = cm.getTime();
        System.err.println("Calendar���ʱ�䣺" + d);
        System.err.println("new Date������ʱ�䣺" + date);
        //getTimeInMillis():���ش� Calendar ��ʱ��ֵ���Ժ���Ϊ��λ�� 
        long dl = c.getTimeInMillis();
        long ddate = cm.getTimeInMillis();
        System.err.println("��������" + dl);
        System.err.println("��������" + ddate);
        
        //setTimeInMillis():�ø����� long ֵ���ô�Calendar�ĵ�ǰʱ��ֵ�� 
        long sv = 123456;
        Calendar sc = Calendar.getInstance();
        sc.setTimeInMillis(sv);
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String st = ss.format(sc.getTime());
        System.err.println(st);
        
        //get():���ظ��������ֶε�ֵ��
        int year = c.get(Calendar.YEAR);
        System.err.println(year);
        
        //set():�������������ֶ�����Ϊ����ֵ
        c.set(Calendar.YEAR, 2);
        int y = c.get(Calendar.YEAR);
        System.err.println(y);//���2
        
        //Calendar�Ƚϣ�before(),after(),equals(),compareTo().
        try{
            String startTime = "2012-12-12 12:45:39";
            String endTime = "2012-12-12 12:45:40";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            start.setTime(startDate);
            end.setTime(endDate);
            if(start.before(end)){
                System.err.println("��ʼʱ��С�ڽ���ʱ��");
            }else if(start.after(end)){
                System.err.println("��ʼʱ����ڽ���ʱ��");
            }else if(start.equals(end)){
                System.err.println("��ʼʱ����ڽ���ʱ��");
            }
            /*
             * start < end ����-1
             * start = end ����0
             * start > end ����1
             */
            int count = start.compareTo(end);
            System.err.println(count);
            
            //add():Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
            start.add(Calendar.YEAR, -3);
            System.err.println("ԭ����ʱ�䣺" + startTime);
            System.err.println("add���ʱ�䣺" + sdf.format(start.getTime()));
            
            //toString():ת��Ϊ�ַ���
            System.err.println(start.toString());
        }catch(Exception e){}
    }
    //��������
    public static void param(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        //Calendar.YEAR:�����е���
        int year = c.get(Calendar.YEAR);
        //Calendar.MONTH:�����е��£���Ҫ��1
        int mounth = c.get(Calendar.MONTH) + 1;
        //Calendar.DATE:�����е���
        int day = c.get(Calendar.DATE);
        //Calendar.HOUR:�����е�Сʱ(12Сʱ��)
        int hour = c.get(Calendar.HOUR);
        //Calendar.HOUR_OF_DAY��24Сʱ��
        int HOUR_OF_DAY = c.get(Calendar.HOUR_OF_DAY);
        //Calendar.MINUTE:�����еķ���
        int minute = c.get(Calendar.MINUTE);
        //Calendar.SECOND:�����е���
        int second = c.get(Calendar.SECOND);
        System.err.println(year + "-" + mounth + "-" + day + " " + hour + ":" + minute + ":" + second);
        
        //Calendar.WEEK_OF_YEAR:��ǰ����������
        int WEEK_OF_YEAR = c.get(Calendar.WEEK_OF_YEAR);
        //Calendar.WEEK_OF_MONTH:��ǰ����������
        int WEEK_OF_MONTH = c.get(Calendar.WEEK_OF_MONTH);
        //Calendar.DAY_OF_YEAR:��ǰ���еĵڼ���
        int DAY_OF_YEAR = c.get(Calendar.DAY_OF_YEAR);
        //Calendar.DAY_OF_MONTH:��ǰ���еĵڼ���
        int DAY_OF_MONTH = c.get(Calendar.DAY_OF_MONTH);
        //Calendar.DAY_OF_WEEK:��ǰ���ڵĵڼ���(�������ʾ��һ�죬��������ʾ������)
        int  DAY_OF_WEEK = c.get(Calendar.DAY_OF_WEEK);
        //Calendar.DAY_OF_WEEK_IN_MONTH:��ǰ���еĵڼ�������
        int DAY_OF_WEEK_IN_MONTH = c.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date ampm = format.parse("2012-12-15 21:59:59");
            Calendar cc = Calendar.getInstance();
            cc.setTime(ampm);
            //AM_PM:HOUR ��������֮ǰ����������֮��,������12��֮ǰ����0��������12��(����12��)֮�󷵻�1
            int AM_PM = cc.get(Calendar.AM_PM);
        }catch(Exception e){}
        
    }
}
