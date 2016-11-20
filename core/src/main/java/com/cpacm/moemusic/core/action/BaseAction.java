package com.cpacm.moemusic.core.action;

import com.cpacm.moemusic.core.http.RetrofitManager;

import retrofit2.Retrofit;

/**
 * Created by DIY on 2016/11/16.
 */

public class BaseAction {

//    protected Retrofit retrofit;
//
//    public BaseAction(){
//        this.retrofit= RetrofitManager.getInstance().getRetrofit();
//    }
    protected Retrofit retrofit;
    protected String accessToken;

    public BaseAction(){
        this.retrofit=RetrofitManager.getInstance().getRetrofit();
        this.accessToken=RetrofitManager.getInstance().getAccessToken();
    }
}
