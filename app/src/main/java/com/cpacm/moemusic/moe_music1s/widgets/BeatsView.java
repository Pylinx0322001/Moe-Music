import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

//package com.cpacm.moemusic.moe_music1s.widgets;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//
///**
// * Created by DIY on 2016/11/16.
// */
//
//public class BeatsView extends View {
//    public BeatsView(Context context){
//        super(context);
//    }
//
//    public BeatsView(Context context, AttributeSet attrs,int defStyleAttr){
//        super(context,attrs,defStyleAttr);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//        int desiredWidth=0;
//        int desiredHeight=0;
//        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
//        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
//
//        int measuredWidth,measuredHeight;
//
//        if(widthMode==MeasureSpec.AT_MOST){
//            measuredWidth=desiredWidth;
//        }else{
//            measuredWidth=widthSize;
//        }
//
//        if(heightMode==MeasureSpec.AT_MOST){
//            measuredHeight=desiredHeight;
//        }else{
//            measuredHeight=heightSize;
//        }
//
//        setMeasuredDimension(measuredWidth,measuredHeight);
//    }
//}
public class BeatsView extends View{
    private Paint paint;
    private int beats=1;
    private int screenW,screenH;
    private float X,Y;
    private Path path;
    private float initialScreenW;
    private float initialX,plusX;
    private float TX;
    private boolean translate;
    private int flash;

    public BeatsView(Context context){
        super(context);
        initView(context);
    }

    public BeatsView(Context context,AttributeSet attrs){
        super(context,attrs);
        initView(context);
    }

    public BeatsView(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        paint=new Paint();
        //设置绘制的颜色，a代表透明度,r,g,b代表颜色值
        paint.setColor(Color.argb(0xff,0x99,0x00,0x00));
        //画笔宽度
        paint.setStrokeWidth(10);
        //抗锯齿
        paint.setAntiAlias(true);
        //设置笔触风格
        paint.setStrokeCap(Paint.Cap.ROUND);
        //设置结合处的样子Miter：结合处为锐角，Round：结合处为圆弧
        //BEVEL结合处为直线
        paint.setStrokeJoin(Paint.Join.ROUND);
        //设置风格 Paint.Style.STROKE为描边 Paint.Style.FILL为实心
        //FILL_AND_STROKE为填充内部和描边
        paint.setStyle(Paint.Style.STROKE);
        //设置阴影 参数：x方向的位移，y方向的位移，阴影颜色
        paint.setShadowLayer(7,0,0,Color.RED);

        path=new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenH=h;
        screenW=w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        invalidate();
    }
}
