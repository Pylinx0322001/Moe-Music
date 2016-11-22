package com.cpacm.moemusic.core.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.cpacm.moemusic.core.CoreApplication;

/**
 * Created by DIY on 2016/11/14.
 * @desciption: app设置管理类，主要记录一些用户的设置和用户的首次操作
 */

public class SettingManager {

    private static SettingManager instance;

    public static SettingManager getInstance(){
        if(instance==null){
            synchronized(SettingManager.class){
                if(instance==null){
                    instance=new SettingManager();
                }
            }
        }
        return instance;
    }

    //设置文件的文件名
    private static final String SETTING_PREFERENCE="SETTINGMANAGER";

    //app第一次启动
    public static final String FIRST_APP_START="first_app_start";
    public static final String ACCESS_TOKEN="access_token";
    public static final String ACCESS_TOKEN_SECRET="access_token_secret";

    private SharedPreferences sharedPreferences;
    private Context context;
    private SettingManager(){
        context= CoreApplication.getInstance().getApplicationContext();
    }

    //获取setting的sp文件
    public SharedPreferences getSharedPreferences(){
        if(sharedPreferences==null){
            sharedPreferences=context.
                    getSharedPreferences(SETTING_PREFERENCE,Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public void setSetting(String key,String value){
        SharedPreferences.Editor editor=getSharedPreferences().edit();
        editor.putString(key,value);
        editor.commit();
    }

    public String getSetting(String key){
        return getSharedPreferences().getString(key,"");
    }

    public String getSetting(String key,String defaultValues){
        return getSharedPreferences().getString(key,defaultValues);
    }

    public void setSetting(String key,boolean flag){
        SharedPreferences.Editor editor=getSharedPreferences().edit();
        editor.putBoolean(key,flag);
        editor.commit();
    }

    public Boolean getSetting(String key,boolean defaultValue){
        return getSharedPreferences().getBoolean(key,defaultValue);
    }
}
