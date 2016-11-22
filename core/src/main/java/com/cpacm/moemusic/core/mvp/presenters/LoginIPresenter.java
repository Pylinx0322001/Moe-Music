package com.cpacm.moemusic.core.mvp.presenters;

import com.github.scribejava.core.model.OAuth1AccessToken;

/**
 * Created by DIY on 2016/11/19.
 */

public interface LoginIPresenter {
    void OauthRedirect(String url);
    //void LoginSuccess(String accessToken);
    void LoginSuccess(OAuth1AccessToken accessToken);
    void LoginFailed(Throwable e);
}
