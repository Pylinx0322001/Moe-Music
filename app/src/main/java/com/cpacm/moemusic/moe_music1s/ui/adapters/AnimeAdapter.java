package com.cpacm.moemusic.moe_music1s.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DIY on 2016/11/23.
 * @desciption: 动画页面数据适配器
 */

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter
        .AnimeViewHolder>{

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder holder, int position) {

    }

    public class AnimeViewHolder extends RecyclerView.ViewHolder{

        public AnimeViewHolder(View itemview){
            super(itemview);
        }
    }
}
