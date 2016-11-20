package com.cpacm.moemusic.moe_music1s.ui.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.afollestad.materialdialogs.MaterialDialog;
import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.presenter.LoginPresenter;
import com.cpacm.moemusic.moe_music1s.ui.login.WebAppBridge;
import com.cpacm.moemusic.moe_music1s.utils.FileManager;

/**
 * Created by DIY on 2016/11/19.
 * @desciption: oauth验证对话框
 */

public class OauthDialog extends DialogFragment {

//    public OauthDialog(Context context){
//        super(context);
//    }

//    public OauthDialog(Context context,int themeResId){
//        super(context,themeResId);
//    }

//    protected OauthDialog(Context context,boolean cancelable,
//                          OnCancelListener cancelListener){
//        super(context,cancelable,cancelListener);
//    }

    private final String JSAPP="oauth";

    public static OauthDialog create(){
        OauthDialog dialog=new OauthDialog();
        return dialog;
    }

    private WebView webView;
    private ProgressBar progressBar;
    private String account,password;
    private LoginPresenter loginPresenter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View customView;
        try{
            customView= LayoutInflater.from(getActivity())
                    .inflate(R.layout.dialog_oauth,null);
        }catch(InflateException e){
            throw new IllegalStateException("This device does not support Web Views");
        }
        MaterialDialog dialog=new MaterialDialog.Builder(getActivity())
                .title(R.string.login)
                .customView(customView,false)
                .build();
        webView=(WebView)customView.findViewById(R.id.webview);
        initWebView();
        progressBar=(ProgressBar)customView.findViewById(android.R.id.progress);
        setupProgress(progressBar);
        return dialog;
    }

    private void setupProgress(final ProgressBar progressBar){
        if(progressBar==null) return;
        //true为显示目前的进度，false为在最大值和最小值之前移动
        progressBar.setIndeterminate(true);
        //设置当前进度
        progressBar.setProgress(0);
        progressBar.setMax(0);
    }

    private void initWebView(){
        WebSettings webSettings=webView.getSettings();
        //启用或禁用WebView访问文件数据
        webSettings.setAllowFileAccess(true);
        //设置WebView是否可以运行JavaScript;
        webSettings.setJavaScriptEnabled(true);
        //启用或禁用DOM缓存
        webSettings.setDomStorageEnabled(true);
        //启用或禁用应用缓存
        webSettings.setAppCacheEnabled(true);
        //启用或禁用数据库缓存
        webSettings.setDatabaseEnabled(true);

        webView.addJavascriptInterface(
                new WebAppBridge(new WebAppBridge.OauthLoginImp1(){
                    @Override
                    public void getResult(String s) {
                        loginPresenter.LoginFailed(s);
                        //取消对话框
                        dismiss();
                    }
                }),
                JSAPP);

        webView.setWebViewClient(new WebViewClient(){
            /**
             * 该方法只在WebView完成一个页面加载时调用一次,我们可以在
             * 此关闭加载动画，进行其他操作
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(url.contains("http://api.moefou.org/oauth/authorize")){
                    webView.loadUrl("javascript:"+getAssetsJs("autologin.js"));
                    webView.loadUrl("javascript:adduplistener()");
                    String js="javascript:autologin('" + account + "','" + password + "')";
                    webView.loadUrl(js);
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String v="";
                String[] ss=url.split("&");
                for(int i=0;i<ss.length;i++){
                    if(ss[i].contains("oauth_verifiere=")){
                        String verifier=ss[i].substring(ss[i].indexOf("=")+1,
                                ss[i].length());
                        if(verifier !=null && !verifier.equals("")){
                            v=verifier;
                            break;
                        }
                    }
                }
                loginPresenter.getAccessToken(v);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    public String getAssetsJs(String filename){
        return FileManager.getAssets(getActivity(),filename);
    }

    public void setLoginPresenter(LoginPresenter loginPresenter,String accout,
                                  String password){
        this.account=accout;
        this.password=password;
        this.loginPresenter=loginPresenter;
    }

    public void redirectUrlAndLogin(String url){
        webView.loadUrl(url);
    }
}
