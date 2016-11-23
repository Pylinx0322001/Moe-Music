package com.cpacm.moemusic.moe_music1s.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cpacm.moemusic.moe_music1s.R;

import java.util.List;

/**
 * Created by DIY on 2016/11/23.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public ListViewHolder(View itemView){
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.content_text);
    }
}
