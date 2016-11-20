package com.cpacm.moemusic.moe_music1s.presenter;

import com.cpacm.moemusic.core.action.OauthAction;
import com.cpacm.moemusic.core.cache.SettingManager;
import com.cpacm.moemusic.core.mvp.presenters.LoginIPresenter;
import com.cpacm.moemusic.core.mvp.presenters.LoginIView;

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

    @Override
    public void LoginSuccess(String accessToken) {
        SettingManager.getInstance()
                .setSetting(SettingManager.ACCESS_TOKEN,accessToken);
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
