package com.cpacm.moemusic.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cpacm.moemusic.core.db.dao.AccountDao;

/**
 * Created by DIY on 2016/11/14.
 * @desciption: 数据库帮助类
 */

public class DBHelper extends SQLiteOpenHelper {

//    public static final String INFORMATIONTABLE="UserInformation";
//    public static final String MESSAGETABLE="UserMessage";
    private static final String DATABASENAME="beats.db";
    private static final int DATABASEVERSION=1;

    public DBHelper(Context context,String name,SQLiteDatabase.
                    CursorFactory factory,int version){
        super(context,name,factory,version);
    }



    public DBHelper(Context context){
        super(context,DATABASENAME,null,DATABASEVERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        //建立用户信息表
//        createInformationTable(db);
        db.execSQL(AccountDao.createtable());
        db.execSQL(AccountDao.createIndex());
        //用户表
        //歌曲表
        //收藏夹表

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    public void createInformationTable(SQLiteDatabase db){
//        db.execSQL("create table UserInformation(_id integer primary key " +
//                "autoincrement,name varchar(20),status varchar(50)," +
//                "pic varchar(20))");
//    }
    //增加一项，保存用户数据
    //db.execSQL("ALTER TABLE note ADD COLUMN marktes integer");
    //onCreate(db);
}
