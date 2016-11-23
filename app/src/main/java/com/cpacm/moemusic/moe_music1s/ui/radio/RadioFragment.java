package com.cpacm.moemusic.moe_music1s.ui.radio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpacm.moemusic.moe_music1s.MoeApplication;
import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.ui.BaseFragment;

/**
 * Created by DIY on 2016/11/23.
 * desciption: 电台界面
 */

public class RadioFragment extends BaseFragment {
    public static final String TITLE= MoeApplication.getInstance()
            .getString(R.string.radio);

    public static RadioFragment newInstance(){
        RadioFragment fragment=new RadioFragment();
        return fragment;
    }

    public RadioFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView=inflater.inflate(R.layout.fragment_radio,
                container,false);
        return parentView;
    }
}
