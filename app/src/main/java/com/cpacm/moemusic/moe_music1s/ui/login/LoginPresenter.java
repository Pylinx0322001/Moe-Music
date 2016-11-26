package com.cpacm.moemusic.moe_music1s.ui.login;

import com.cpacm.moemusic.core.action.OauthAction;
import com.cpacm.moemusic.core.cache.SettingManager;
import com.cpacm.moemusic.core.http.RetrofitManager;
import com.cpacm.moemusic.core.mvp.presenters.LoginIPresenter;
import com.cpacm.moemusic.core.mvp.presenters.LoginIView;
import com.cpacm.moemusic.core.utils.MoeLogger;
import com.github.scribejava.core.model.OAuth1AccessToken;

/**
 * Created by DIY on 2016/11/20.
 * @desciption: 登录逻辑处理
 */

public class LoginPresenter implements LoginIPresenter {

    private LoginIView loginIView;
    private OauthAction oauthAction;

    public LoginPresenter(LoginIView loginIView){
        this.loginIView=loginIView;
        oauthAction=new OauthAction(this);
    }

    public void login(){
        oauthAction.startOauth();
    }

    public void getAccessToken(String verifier){
        oauthAction.getAccessToken(verifier);
    }

    public void LoginFailed(String s) {
        loginIView.LoginFailed(s);
    }

//    @Override
//    public void LoginSuccess(String accessToken) {
//        SettingManager.getInstance()
//                .setSetting(SettingManager.ACCESS_TOKEN,accessToken);

    @Override
    public void LoginSuccess(OAuth1AccessToken accessToken) {
        MoeLogger.d(accessToken.getToken());
        MoeLogger.d(accessToken.getTokenSecret());
        SettingManager.getInstance().setSetting(SettingManager.ACCESS_TOKEN,
                accessToken.getToken());
        SettingManager.getInstance().
                setSetting(SettingManager.ACCESS_TOKEN_SECRET,
                        accessToken.getTokenSecret());
        //RetrofitManager.getInstance().build();
        loginIView.LoginSuccess();
    }

    @Override
    public void OauthRedirect(String url) {
        loginIView.OauthRedirect(url);
    }

    @Override
    public void LoginFailed(Throwable e) {
        loginIView.LoginFailed();
    }
}
