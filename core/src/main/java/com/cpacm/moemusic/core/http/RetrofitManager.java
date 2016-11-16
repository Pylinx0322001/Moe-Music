package com.cpacm.moemusic.core.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DIY on 2016/11/16.
 * @desciption: Retrofit初始化
 */

public class RetrofitManager {

    private static RetrofitManager ourInstance;
    private Retrofit retrofit;

    public static RetrofitManager getInstance(){
        if(ourInstance==null){
            ourInstance=new RetrofitManager();
        }
        return ourInstance;
    }

    private RetrofitManager(){
        OkHttpClient.Builder httpClientBuilder=new OkHttpClient.Builder();
        //设置超时时间，单位为秒
        httpClientBuilder.connectTimeout(HttpUtil.DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit=new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(HttpUtil.BASE_URL)
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit){
        this.retrofit=retrofit;
    }
}
