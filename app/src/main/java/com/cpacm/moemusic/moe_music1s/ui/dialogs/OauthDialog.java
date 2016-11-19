package com.cpacm.moemusic.moe_music1s.ui.dialogs;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by DIY on 2016/11/19.
 * @desciption: oauth验证对话框
 */

public class OauthDialog extends Dialog {

    public OauthDialog(Context context){
        super(context);
    }

    public OauthDialog(Context context,int themeResId){
        super(context,themeResId);
    }

    protected OauthDialog(Context context,boolean cancelable,
                          OnCancelListener cancelListener){
        super(context,cancelable,cancelListener);
    }
}
