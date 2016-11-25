package com.cpacm.moemusic.moe_music1s.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpacm.moemusic.moe_music1s.R;



import java.util.List;

/**
 * Created by DIY on 2016/11/23.
 */

public class RecyclerViewListAdapter extends
        RecyclerView.Adapter<ListViewHolder>{

    private List<String> dataList;
    private TestListener testListener;

    public RecyclerViewListAdapter(List<String> dataList){
        this.dataList=dataList;
    }

    public void addData(List<String> dataList){
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder,final int position) {
        holder.textView.setText(dataList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                testListener.onClick(dataList.get(position));
            }
        });
    }

    public void setTextListener(TestListener testListener){
        this.testListener=testListener;
    }

    @Override
    public int getItemCount() {
        return dataList==null?0:dataList.size();
    }

    public interface TestListener{
        void onClick(String s);
    }
}
