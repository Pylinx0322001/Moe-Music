package com.cpacm.moemusic.core.utils;


import android.util.Log;

/**
 * Created by DIY on 2016/11/15.
 * @desciption: Log帮助类
 * 请在发布时去掉注释
 */

public class MoeLogger {
    private static String TAG="MOE";

    //public static boolean DEBUG= BuildConfig.DEBUG;
    public static boolean DEBUG=true;

    public static void setTag(String tag){
        d("Changing log tag to %s",tag);
        TAG=tag;
        DEBUG=Log.isLoggable(TAG,Log.VERBOSE);
    }

    public static void d(String format,Object... args){
        try{
            String msg=(args==null)?format:String.format(format,args);
            if(DEBUG){
                Log.d(TAG,msg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void v(String format,Object... args){
        try{
            String msg=(args==null)?format:String.format(format,args);
            if(DEBUG){
                Log.v(TAG,msg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void e(String format,Object... args){
        try{
            String msg=(args==null)?format:String.format(format,args);
            if(DEBUG){
                Log.v(TAG,msg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void whf(String format,Object... args){
        try{
            String msg=(args==null)?format:String.format(format,args);
            if(DEBUG){
                Log.v(TAG,msg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
