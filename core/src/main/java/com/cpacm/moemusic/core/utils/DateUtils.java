package com.cpacm.moemusic.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DIY on 2016/11/15.
 * @desciption: 时间日期工具
 */

public class DateUtils {

    //返回unix时间戳（1970年至今的秒数）
    public static long getUnixStamp(){
        return System.currentTimeMillis()/1000;
    }

    //得到昨天的日期
    public static String getYesterdayDate(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String yestoday=sdf.format(calendar.getTime());
        return yestoday;
    }

    //得到今天的日期
    public static String getTodayDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(new Date());
        return date;
    }

    //获取今天0时的时间戳
    public static long getTodayTime(){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.MILLISECOND,0);
        return cal.getTimeInMillis()/1000;
    }

    //过去昨天0时的时间戳
    public static long getYesterdayTime(){
        return getTodayTime()-24*3600*1000;
    }

    //时间戳转化为时间格式
    public static String timeStampToStr(long timeStamp){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date=sdf.format(timeStamp*1000);
        return date;
    }

    //得到日期 yyyy-MM-dd
    public static String formatDate(long timeStamp){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(timeStamp*1000);
        return date;
    }

    //得到时间  HH:mm:ss
    public static String getTime(long timeStamp){
        String time=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(timeStamp*1000);
        String[] split=date.split("\\s");
        if(split.length>1){
            time=split[1];
        }
        return time;
    }

    //将一个时间戳转换成提示性时间字符串
    public static String convertTimeToFormat(long timeStamp){
        //秒数
        timeStamp=timeStamp/(long)1000;
        long curTime=System.currentTimeMillis()/(long)1000;
        long time=curTime-timeStamp;

        if(time<60){
            return "刚刚";
        }else if(time>=60 && time<3600){
            return time/60+"分钟前";
        }else if(time>=3600 && time<=3600*24){
            return time/3600+"小时前";
        }else{
            return formatDate(timeStamp);
        }
    }

    public static String convertTimeToFormat(String timeStr){
        long timeStamp=Long.decode(timeStr);
        timeStamp=timeStamp/(long)1000;
        long curTime=System.currentTimeMillis()/(long)1000;
        long time=curTime-timeStamp;

        if(time<60){
            return "刚刚";
        }else if(time>=60 && time<=3600){
            return time/60+"分钟前";
        }else if(time>=3600 && time<=3600*24){
            return time/3600+"小时前";
        }else{
            return formatDate(timeStamp);
        }
    }

    //将一个时间戳转换成提示性时间字符串，（多少分钟）
    public static String timeStampToFormat(long timeStamp){
        long curTime=System.currentTimeMillis()/(long)1000;
        long time=curTime-timeStamp;
        return time/60+"";
    }
}
