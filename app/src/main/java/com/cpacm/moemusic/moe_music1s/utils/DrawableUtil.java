package com.cpacm.moemusic.moe_music1s.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

/**
 * Created by DIY on 2016/11/18.
 * @desciption:
 */

public class DrawableUtil {
    //可以一张图片实现多种状态显示此处展示了按下和默认时候的颜色
    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors){
        final Drawable wrappedDrawable= DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable,colors);
        return wrappedDrawable;
    }
}
