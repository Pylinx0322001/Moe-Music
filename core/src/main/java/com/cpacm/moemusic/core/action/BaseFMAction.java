package com.cpacm.moemusic.core.action;

import com.cpacm.moemusic.core.http.HttpUtil;
import com.cpacm.moemusic.core.http.RetrofitManager;
import com.cpacm.moemusic.core.oauth.MoefouApi;
import com.cpacm.moemusic.core.utils.MoeLogger;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

import retrofit2.Retrofit;

/**
 * Created by DIY on 2016/11/25.
 */

public abstract class BaseFMAction {
    protected Retrofit retrofit;
    protected String accessToken,accessTokenSecret;
    private String baseUrl;
    protected String url;
    protected String authorization;

    public BaseFMAction(String shortUrl){
        this.retrofit= RetrofitManager.getInstance().getFMRetrofit();
        this.accessToken=RetrofitManager.getInstance().getAccessToken();
        this.accessTokenSecret=RetrofitManager.getInstance().getAccessTokenSecret();
        this.baseUrl= HttpUtil.BASE_FM_URL;
        this.url=baseUrl+shortUrl;
        this.authorization=getOauthHeader(url);
    }

    public String getOauthHeader(String url){
        MoeLogger.d(accessToken);
        MoeLogger.d(accessTokenSecret);
        OAuth1AccessToken oauthToken=
                new OAuth1AccessToken(accessToken,accessTokenSecret);
        OAuth10aService service=new ServiceBuilder()
                .apiKey(MoefouApi.ConsumerKey)
                .apiSecret(MoefouApi.ConsumerSecret)
                .build(MoefouApi.instance());
        final OAuthRequest request=new OAuthRequest(Verb.GET,url,service);
        service.signRequest(oauthToken,request);
        StringBuilder header=new StringBuilder();
        header.append(request.getHeaders().get("Authorization"));
        return header.toString();
    }

}
