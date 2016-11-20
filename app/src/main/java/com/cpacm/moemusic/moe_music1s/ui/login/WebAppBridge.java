package com.cpacm.moemusic.moe_music1s.ui.login;

import android.webkit.JavascriptInterface;

/**
 * Created by DIY on 2016/11/20.
 */

public class WebAppBridge {

    private OauthLoginImp1 oauthLogin;

    public WebAppBridge(OauthLoginImp1 oauthLogin){
        this.oauthLogin=oauthLogin;
    }

    @JavascriptInterface
    public void getResult(String str){
        if(oauthLogin !=null){
            oauthLogin.getResult(str);
        }
    }

    public interface OauthLoginImp1{
        void getResult(String s);
    }
}
