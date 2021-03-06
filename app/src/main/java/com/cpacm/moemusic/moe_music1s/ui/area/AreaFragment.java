package com.cpacm.moemusic.moe_music1s.ui.area;

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
 */

public class AreaFragment extends BaseFragment{
    public static final String TITLE= MoeApplication.getInstance()
            .getString(R.string.area);

    public static AreaFragment newInstance(){
        AreaFragment fragment=new AreaFragment();
        return fragment;
    }

    public AreaFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView=inflater.inflate(R.layout.fragment_area,
                container,false);
        return parentView;
    }
}
