package com.demo.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date的常用方法小结
 *
 * @author huawangxin
 * 
 */
public class LearnDate {
    public static void main(String[] args){
        
        Date cdate = new Date();
        System.err.println("当前时间: " + cdate);
        
        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
        long dddat = cdate.getTime();
        Date ddate = new Date(dddat);
        System.err.println("自1970年1月1日 00:00:00的毫秒数: " + dddat);
        System.err.println("构造方法使用后的时间: " + ddate);
        
        //设置此Date对象，以表示1970年1月1日 00:00:00 GMT 以后 time 毫秒的时间点
        Date sflag = new Date();
        sflag.setTime(dddat);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println(sdf.format(sflag));
        
        //Date对象的比较before(),after(),equals(),compareTo()
        try{
            String startTime = "2012-9-25 12:12:12";
            String endTime = "2012-10-25 12:12:12";
            SimpleDateFormat se = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startDate = se.parse(startTime);
            Date endDate = se.parse(endTime);
            if(startDate.before(endDate)){
                System.err.println("开始时间小于结束时间");
            }else if(startDate.after(endDate)){
                System.err.println("开始时间大于结束时间");
            }else if(startDate.equals(endDate)){
                System.err.println("开始时间等于结束时间");
            }
            /*
             * startDate > endDate 返回1
             * startDate == endDate 返回0
             * startDate < endDate 返回-1
             */
            int flag = startDate.compareTo(endDate);
            System.err.println("flag = " + flag);
            
            //toString():输出：Fri Oct 12 10:58:01 CST 2012
            Date cc = new Date();
            String ccc = cc.toString();
            System.err.println("日期转换为String：" + ccc);
        }catch(Exception e){}
    }
}
