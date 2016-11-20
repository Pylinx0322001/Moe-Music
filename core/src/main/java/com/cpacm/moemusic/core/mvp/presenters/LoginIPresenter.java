package com.cpacm.moemusic.core.mvp.presenters;

/**
 * Created by DIY on 2016/11/19.
 */

public interface LoginIPresenter {
    void OauthRedirect(String url);
    void LoginSuccess(String accessToken);
    void LoginFailed(Throwable e);
}
