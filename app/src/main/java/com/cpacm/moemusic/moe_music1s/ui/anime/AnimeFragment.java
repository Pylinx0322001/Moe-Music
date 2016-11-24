package com.cpacm.moemusic.moe_music1s.ui.anime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpacm.moemusic.moe_music1s.MoeApplication;
import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.ui.BaseFragment;

/**
 * Created by DIY on 2016/11/23.
 * @desciption: 动画分类界面
 */

public class AnimeFragment extends BaseFragment {

    public static final String TITLE= MoeApplication.getInstance()
            .getString(R.string.anime);

    private RecyclerView recyclerView;

    public static AnimeFragment newInstance(){
        AnimeFragment fragment=new AnimeFragment();
        return fragment;
    }

    public AnimeFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView=inflater.inflate(R.layout.fragment_anime,
                container,false);
        return parentView;
    }
}
