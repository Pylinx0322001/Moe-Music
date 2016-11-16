package com.cpacm.moemusic.core.utils;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.cpacm.moemusic.core.CoreApplication;

/**
 * Created by DIY on 2016/11/15.
 * @desciption: 获取一些App系统的参数
 */

public class SystemParamsUtil {

    //获取版本号
    public static String getAppVersionName(Context context){
        PackageManager manager=context.getPackageManager();
        String appVersionName="";
        try{
            PackageInfo info=manager.getPackageInfo(context.getPackageName(),0);
            appVersionName=info.versionName;//版本号，versionCode同理
        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return appVersionName;
    }

    //获取设备号
    public static TelephonyManager getTelephonyManager(){
        TelephonyManager tm=(TelephonyManager) CoreApplication.getInstance()
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tm;
    }

    public static String getHandSetInfo(){
        String handSetInfo="手机型号："+ Build.MODEL+
                            "SDK版本："+ Build.VERSION.SDK+
                            "系统版本："+ Build.VERSION.RELEASE;
        return handSetInfo;
    }

    public static String getAppChannel(Context context,String key){
        try{
            ApplicationInfo ai=context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            Object value=ai.metaData.get(key);
            if(value !=null){
                MoeLogger.v("渠道名："+value.toString());
                return value.toString();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //检查网络是否连接
    public static boolean isNetworkConnected(Context context){
        if(context !=null){
            ConnectivityManager mConnectivityManager=(ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo=mConnectivityManager.getActiveNetworkInfo();
            if(mNetworkInfo !=null){
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //检查wifi网络是否连接
    public static boolean isWIFIConnected(Context context){
        if(context !=null){
            ConnectivityManager mConnectivityManager=(ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo=mConnectivityManager.
                    getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if(mWiFiNetworkInfo != null){
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //检查手机网络是否可用
    public static boolean isMobileConnected(Context context){
        if(context !=null){
            ConnectivityManager mConnectivityManager=(ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo=mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if(mMobileNetworkInfo !=null){
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //设置文字到粘贴板
    public static void setPrimaryClip(Context context){
        android.content.ClipboardManager c=(android.content.ClipboardManager)
                context.getSystemService(Context.CLIPBOARD_SERVICE);
        //newPlainText(label, text)返回ClipData对象,数据是
        // 文字text,描述是label
        c.setPrimaryClip(ClipData.newPlainText("wechat",""));
    }

    public static boolean hasContractPermission(Context context){
        PackageManager pm=context.getPackageManager();
        boolean permission=(PackageManager.PERMISSION_GRANTED==
                    pm.checkPermission("android.permission.READ_CONTACTS",
                            "com.caitu99.ifen"));
        return permission;
    }
}
