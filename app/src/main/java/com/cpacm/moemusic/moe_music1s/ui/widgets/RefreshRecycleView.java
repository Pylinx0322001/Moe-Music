package com.cpacm.moemusic.moe_music1s.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.cpacm.moemusic.moe_music1s.R;


/**
 * Created by DIY on 2016/11/24.
 * @desciption: 可上拉下拉加载的RecycleView
 */

public class RefreshRecycleView extends LinearLayout {

    private SwipeRefreshLayout swipRefreshLayout;
    private RecyclerView recyclerView;
    private View headerView;
    private View loadView;

    private boolean swipeRefresh=true;
    private boolean moreRefresh=true;

    public RefreshRecycleView(Context context){
        super(context);

    }

    public RefreshRecycleView(Context context, AttributeSet attrs){
        super(context,attrs);

    }

    public RefreshRecycleView(Context context,AttributeSet attrs,
                              int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }

    public void initView(Context context,AttributeSet attrs){
        //这里取得declare-styleable集合
        TypedArray typeArray=context
                .obtainStyledAttributes(attrs, R.styleable.RefreshRecycleView);
        /**
         * 这里从集合里去除相对应的属性值，第二参数是如果使用者没用配置该属性时
         * 所用的默认值
         */
        swipeRefresh=typeArray.getBoolean(R.styleable.RefreshRecycleView_swipe_refresh,true);
        moreRefresh=typeArray.getBoolean(R.styleable.RefreshRecycleView_more_refresh,true);
        boolean refresh=typeArray.getBoolean(R.styleable.RefreshRecycleView_refresh,true);
        if(refresh){
            swipeRefresh=true;
            moreRefresh=true;
        }else{
            swipeRefresh=false;
            moreRefresh=false;
        }
        int loadViewId=typeArray.getResourceId(R.styleable.RefreshRecycleView_more_view,
                R.layout.refresh_loadmore_layout);
        loadView= LayoutInflater.from(context).inflate(loadViewId,null);
        int headerViewId=typeArray.getResourceId(R.styleable.RefreshRecycleView_header_view,-1);
        if(headerViewId !=-1)
            headerView=LayoutInflater.from(context).inflate(headerViewId,null);
        typeArray.recycle();
        initView(context);
    }

    private void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.refresh_recycleview_layout,
                null,true);
        swipRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe_layout);
        recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        if(loadView==null)
        loadView=LayoutInflater.from(context).inflate(R.layout.refresh_loadmore_layout,null);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }


}
