package com.cpacm.moemusic.moe_music1s.ui.comic;

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
 * @desciption: 漫画分类fragment
 */

public class ComicFragment extends BaseFragment {

    public static final String TITLE= MoeApplication.getInstance()
            .getString(R.string.comic);

    public static ComicFragment newInstance(){
        ComicFragment fragment=new ComicFragment();
        return fragment;
    }

    public ComicFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView=inflater.inflate(R.layout.fragment_comic,
                container,false);
        return parentView;
    }
}
