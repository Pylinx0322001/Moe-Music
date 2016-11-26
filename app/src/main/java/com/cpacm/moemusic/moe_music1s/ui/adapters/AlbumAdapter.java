package com.cpacm.moemusic.moe_music1s.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpacm.moemusic.moe_music1s.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIY on 2016/11/26.
 * @desciption: 歌单适配器
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<String> dataList;
    private AlbumListener albumListener;

//    public AlbumAdapter(List<String> dataList){
//        this.dataList=dataList;
//    }
    public AlbumAdapter(){
        this.dataList=new ArrayList<>();
    }



    public void addData(List<String> dataList){
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,
                parent,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        //holder.textView.setText(dataList.get(position));
        /*holder.textView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
        albumListener.onAlbumClick(dataList.get(position));
        }
        });*/
    }

    public void setAlbumListener(AlbumListener albumListener) {
        this.albumListener = albumListener;
    }

    @Override
    public int getItemCount() {
        return dataList==null?0:dataList.size();
    }

    public interface AlbumListener{
        void onAlbumClick(String s);
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{
        public AlbumViewHolder(View itemView){
            super(itemView);
        }
    }
}
