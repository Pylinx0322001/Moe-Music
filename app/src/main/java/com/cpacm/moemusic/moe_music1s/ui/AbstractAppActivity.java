package com.cpacm.moemusic.moe_music1s.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DIY on 2016/11/16.
 * @desciption: 所有Activity的父类
 */

public abstract class AbstractAppActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState
                    ,PersistableBundle persistentState) {
        super.onCreate(savedInstanceState,persistentState);
    }

    //snackbar的显示
    public void showSnackBar(String toast){
        //getDecorView获得window中最顶层的view
        Snackbar.make(getWindow().getDecorView(),
                toast,Snackbar.LENGTH_SHORT).show();
    }

    //activity的跳转
    public void startActivity(Class activity){
        Intent i=new Intent();
        i.setClass(this,activity);
        startActivity(i);
    }
}
