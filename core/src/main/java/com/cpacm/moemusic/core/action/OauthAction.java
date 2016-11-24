package com.cpacm.moemusic.core.action;

import android.util.Log;

import com.cpacm.moemusic.core.mvp.presenters.LoginIPresenter;
import com.cpacm.moemusic.core.oauth.MoefouApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

import java.io.IOException;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DIY on 2016/11/17.
 * @desciption: oauth验证
 */

public class OauthAction {
//    public OauthAction(){
//    }
    OAuth10aService service;
    OAuth1RequestToken requestToken;
    private LoginIPresenter presenter;

    public OauthAction(LoginIPresenter presenter){
        this.presenter=presenter;
    }

    public void startOauth(){
        Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                service=new ServiceBuilder()
                        .apiKey(MoefouApi.ConsumerKey)
                        .apiSecret(MoefouApi.ConsumerSecret)
                        .build(MoefouApi.instance());
                try{
                    requestToken=service.getRequestToken();
                    //Log.d("cpacm",requestToken.toString());
                    String authUrl=service.getAuthorizationUrl(requestToken);
                    //Log.d("cpacm",authUrl);
                    subscriber.onNext(authUrl);
                }catch (IOException e){
                    e.printStackTrace();
                    subscriber.onError(e);
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.LoginFailed(e);
                    }

                    @Override
                    public void onNext(String s) {
                        presenter.OauthRedirect(s);
                    }
                });
    }

    public void getAccessToken(final String verifier){
        //Observable.create(new Observable.OnSubscribe<String>(){
        Observable.create(new Observable.OnSubscribe<OAuth1AccessToken>(){
            @Override
            //public void call(Subscriber<? super String> subscriber) {
            public void call(Subscriber<? super OAuth1AccessToken> subscriber){
                final OAuth1AccessToken accessToken;
                try{
                    accessToken=service.getAccessToken(requestToken,verifier);
                    //subscriber.onNext(accessToken.getToken());
                    //MoeLogger.d(accessToken.getToken());
                    subscriber.onNext(accessToken);
                }catch(IOException e){
                    e.printStackTrace();
                    subscriber.onError(e);
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.subscribe(new Observer<String>(){
                .subscribe(new Observer<OAuth1AccessToken>(){
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.LoginFailed(e);
                    }


//                    public void onNext(String s) {
//                        presenter.LoginSuccess(s);

                    @Override
                    public void onNext(OAuth1AccessToken token) {
                        presenter.LoginSuccess(token);
                    }
                });
    }
}
