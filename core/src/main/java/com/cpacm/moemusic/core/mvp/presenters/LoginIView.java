package com.cpacm.moemusic.core.mvp.presenters;

/**
 * Created by DIY on 2016/11/19.
 * @desciption: 登录的view接口
 */

public interface LoginIView {
    void OauthRedirect(String url);
    void LoginSuccess();
    void LoginFailed();
    void LoginFailed(String s);
}
