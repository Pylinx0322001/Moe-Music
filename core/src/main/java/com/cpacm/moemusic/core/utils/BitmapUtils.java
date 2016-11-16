package com.cpacm.moemusic.core.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.TypedValue;

import com.cpacm.moemusic.core.CoreApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by DIY on 2016/11/14.
 * @desciption: 一些绘画常用方法
 *
 */

public class BitmapUtils {

    public static Bitmap getBitmapByString(String imgSrc){
        if(imgSrc !=null){
            //NO_WRAP略去所有换行符
            byte[] buf= Base64.decode(imgSrc,Base64.NO_WRAP);
            ByteArrayInputStream bas=new ByteArrayInputStream(buf);
            Bitmap pic= BitmapFactory.decodeStream(bas);
            return pic;
        }else{
            return null;
        }
    }

    public static String setBitmapByString(Bitmap bitmap){
        if(bitmap !=null){
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            //把图片位图按照JPEG格式压缩，压缩比率为50%
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,bos);
            //使用Base64编码将图片的byte数组转换成字符串
            String imgStr=Base64.encodeToString(bos.toByteArray()
                    ,Base64.NO_WRAP);
            return imgStr;
        }else{
            return null;
        }
    }

    //将dip或dp值转换为px值，保证尺寸大小不变
    public static int dp2px(int dp){
        //第一个参数是单位,第二个参数是对应值,第三个封装了显示区域的各种属性值
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, CoreApplication.getInstance().
                        getResources().getDisplayMetrics());
    }

    //将px值转换为dip或dp值，保证尺寸大小不变
    public static int pu2dp(float pxvalue){
        final float scale=CoreApplication.getInstance().getResources()
                            .getDisplayMetrics().density;
        return (int)(pxvalue/scale+0.5f);
    }

    //将sp值转换为px值，保证文字大小不变
    public static int sp2px(float spValue){
        final float fontScale=CoreApplication.getInstance()
                        .getResources().getDisplayMetrics()
                        .scaledDensity;
        return (int) (spValue*fontScale+0.5f);
    }

    //将px值转换为sp值，保证文字大小不变

    public static int px2sp(float pxValue){
        final float fontScale=CoreApplication.getInstance()
                        .getResources().getDisplayMetrics().scaledDensity;
        return (int)(pxValue/fontScale+0.5f);
    }
}
