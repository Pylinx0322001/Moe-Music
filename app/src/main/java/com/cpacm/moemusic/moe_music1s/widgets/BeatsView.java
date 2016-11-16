package com.cpacm.moemusic.moe_music1s.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DIY on 2016/11/16.
 */

public class BeatsView extends View {
    public BeatsView(Context context){
        super(context);
    }

    public BeatsView(Context context, AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int desiredWidth=0;
        int desiredHeight=0;
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);

        int measuredWidth,measuredHeight;

        if(widthMode==MeasureSpec.AT_MOST){
            measuredWidth=desiredWidth;
        }else{
            measuredWidth=widthSize;
        }

        if(heightMode==MeasureSpec.AT_MOST){
            measuredHeight=desiredHeight;
        }else{
            measuredHeight=heightSize;
        }

        setMeasuredDimension(measuredWidth,measuredHeight);
    }
}
