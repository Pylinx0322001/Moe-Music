package com.cpacm.moemusic.core.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cpacm.moemusic.core.CoreApplication;
import com.cpacm.moemusic.core.db.DBHelper;

/**
 * Created by DIY on 2016/11/22.
 * @desciption: 基础Dao层
 */

public abstract class BaseDao {

    protected SQLiteDatabase db;
    protected DBHelper dh;

    public BaseDao(){
        dh=new DBHelper(CoreApplication.getInstance().getApplicationContext());
        db=dh.getWritableDatabase();
    }

    public void close(){
        db.close();
        dh.close();
    }

    public Cursor query(String table,String[] columns,String selection,
                        String[] selectionArgs,String groupBy,String having,
                        String orderBy){
        Cursor c=db.query(table,columns,selection,selectionArgs,groupBy,having,
                orderBy);
        return c;
    }

    public long insert(String table, String nullColumnHack, ContentValues values){
        return db.insert(table,nullColumnHack,values);
    }

    public int delete(String table,String whereClause,String[] whereArgs){
        return db.delete(table,whereClause,whereArgs);
    }

    public int update(String table,ContentValues values,String whereClause,
                      String[] whereArgs){
        return db.update(table,values,whereClause,whereArgs);
    }

    /**
     * 数据替换，原理是先删除存在的整行数据后再重新插入
     * 需要先指定索引才能使用
     */

    public long replace(String table,String nullColumnHack,ContentValues initialValues){
        return db.replace(table,nullColumnHack,initialValues);
    }
}
