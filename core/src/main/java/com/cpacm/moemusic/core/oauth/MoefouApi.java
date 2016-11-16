package com.cpacm.moemusic.core.oauth;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;

/**
 * Created by DIY on 2016/11/16.
 * @desciption: 萌否验证
 */

public class MoefouApi extends DefaultApi10a{

    //https://github.com/scribejava/scribejava/wiki/getting-started
    private static final String ConsumerID="295";
    public static final String ConsumerKey="08d46da476fab6ebc80de34e4f82f47b05829bbd4";
    public static final String ConsumerSecret="0ff455158ab907bc7ccf3e5ccb9fafd0";

    //获取request_token
    private static final String REQUEST_TOKEN_URL=
            "http://api.moefou.org/oauth/request_token";
    //获取用户授权
    private static final String AUTHORIZE_URL=
            "http://api.moefou.org/oauth/authorize";
    //获取access_token
    private static final String ACCESS_TOKEN=
            "http://api.moefou.org/oauth/access_token";

    public MoefouApi(){
    }

    private static class InstanceHolder{
        private static final MoefouApi INSTANCE=new MoefouApi();
    }

    public static MoefouApi instance(){
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN;
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return AUTHORIZE_URL+"?oauth_token="+requestToken.getToken()
                +"&oauth_token_secret="+requestToken.getTokenSecret();
    }
}
