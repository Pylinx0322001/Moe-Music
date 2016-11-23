package com.cpacm.moemusic.moe_music1s.ui.air;

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
 * @desciption: 放映室界面
 */

public class AirFragment extends BaseFragment {

    public static final String TITLE= MoeApplication.getInstance()
            .getString(R.string.on_air);

    public static AirFragment newInstance(){
        AirFragment fragment=new AirFragment();
        return fragment;
    }

    public AirFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView=inflater.inflate(R.layout.fragment_air,
                container,false);
        return parentView;
    }
}
