package com.cpacm.moemusic.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by DIY on 2016/11/14.
 */

public class DBManager {
    private Context mContext=null;
    //用于操作数据库对象
    private SQLiteDatabase mSQLiteDatabase=null;
    private DBHelper dh=null;

    // 数据库名称
    private String dbName="moe";
    //数据库版本
    private int dbVersion=1;

    public DBManager(Context context){
        mContext=context;
    }

    public void open(){
        try{
            dh=new DBHelper(mContext,dbName,null,dbVersion);
            mSQLiteDatabase=dh.getWritableDatabase();
        }catch(SQLiteException e){
            e.printStackTrace();
        }
    }

    public void close(){
        mSQLiteDatabase.close();
        dh.close();
    }
}
