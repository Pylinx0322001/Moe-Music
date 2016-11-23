package com.cpacm.moemusic.moe_music1s.ui.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpacm.moemusic.moe_music1s.MoeApplication;
import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.ui.BaseFragment;
import com.cpacm.moemusic.moe_music1s.ui.adapters.RecyclerViewListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by DIY on 2016/11/23.
 * @desciption: 音乐界面
 */

public class MusicFragment extends BaseFragment {
    public static final String TITLE= MoeApplication.getInstance()
            .getString(R.string.music);

    private RecyclerView recyclerView;
    private static final String itemData="This is some dummy text for shown" +
            "in list view,every single word will be treated as an item";

    public static MusicFragment newInstance(){
        MusicFragment fragment=new MusicFragment();
        return fragment;
    }
    public MusicFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View parentView=inflater.inflate(R.layout.fragment_music,
                container,false);
        recyclerView=(RecyclerView)parentView
                .findViewById(R.id.recycle_view);
        String[] listItems=itemData.split(" ");

        List<String> list=new ArrayList<>();
        Collections.addAll(list,listItems);
        LinearLayoutManager linearlayoutManager=
                new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearlayoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerViewListAdapter adapter=new RecyclerViewListAdapter(list);
        recyclerView.setAdapter(adapter);
        return parentView;
    }
}
