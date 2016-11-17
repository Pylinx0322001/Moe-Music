package com.cpacm.moemusic.moe_music1s.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
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
}
