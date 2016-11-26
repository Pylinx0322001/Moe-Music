package com.cpacm.moemusic.core.http;

/**
 * Created by DIY on 2016/11/14.
 * @desciption: 请求连接
 */

public class HttpUtil {
//    private static final String ConsumerID="295";
//    private static final String ConsumerKey="08d46da476fab6ebc80de34e4f82f47b05829bbd4";
//    private static final String ConsumerSecret="0ff455158ab907bc7ccf3e5ccb9fafd0";
    //超时时间
    public final static int DEFAULT_TIMEOUT=10;

    public final static String BASE_URL="http://api.moefou.org/";

    public final static String NETWORK_ERROR="网络出错";

    public final static String BASE_FM_URL="http://moe.fm/";

    public final static String HITOKOTO_RAND="http://api.hitokoto.us/rand";

    //萌否注册登入页面
    public final static String REGISTER_URL="http://moefou.org/register?redirect=http%3A%2F%2Fmoe.fm%2Flogin";
    //##BASE api##↓
    //获取用户信息
    public final static String ACCOUNT_DETAIL="user/detail.json";

    //获取wikis
    public final static String WIKIS="wikis.json";

    //##FM api##
    //发现音乐
    public final static String EXPLORE="explore";
}
