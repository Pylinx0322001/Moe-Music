package com.cpacm.moemusic.moe_music1s.ui.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.ui.AbstractAppActivity;

/**
 * Created by DIY on 2016/11/19.
 */

public class BaseWebActivity extends AbstractAppActivity {
    private Toolbar toolbar;
    private TextView titleTv;
    private View shadowView;
    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);
        initToolBar();
        webView=(WebView)findViewById(R.id.home_web);
        progressBar=(ProgressBar)findViewById(R.id.webview_progress);
        initView();
    }

    protected void initToolBar(){
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleTv=(TextView)findViewById(R.id.navi_title);
        shadowView=findViewById(R.id.toolbar_shoadow);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            //GONE不显示
            shadowView.setVisibility(View.GONE);
        }
    }

    private void initView() {
        WebSettings webSettings = webView.getSettings();
        //允许访问文件
        webSettings.setAllowFileAccess(true);
        //支持JS
        webSettings.setJavaScriptEnabled(false);
        //关闭webview中缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //自动打开窗口
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(WebSettings
                    .MIXED_CONTENT_ALWAYS_ALLOW);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            //设置是否自动加载图片
            webSettings.setLoadsImagesAutomatically(true);
        } else {
            webSettings.setLoadsImagesAutomatically(false);
        }
        webView.setDownloadListener(new FileDownLoadListener());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                setTitle(title);
            }

            @Override
            public void onProgressChanged(WebView view, int position) {
                progressBar.setProgress(position);
                if(position==100){
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, position);
            }
        });
        webView.setWebViewClient(new BaseWebClient());
    }

    public void startUrl(){
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if(TextUtils.isEmpty(url)) return;
//        String title=intent.getStringExtra(title);
//        titleTv.setText(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==android.R.id.home){
            back();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean back(){
        if(webView.canGoBack())
            webView.goBack();
        else
            onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(webView !=null){
            webView.removeAllViews();
            webView.destroy();
        }
    }

    public void synCookies(final String url){
        final CookieManager cookieManager=CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        removeCookies();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            cookieManager.setAcceptThirdPartyCookies(webView,true);
            cookieManager.flush();
        }else{
            CookieSyncManager.createInstance(webView.getContext());
            CookieSyncManager.getInstance().sync();
        }

    }

    public void removeCookies(){
        CookieManager cookieManager=CookieManager.getInstance();
        cookieManager.removeAllCookie();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            cookieManager.flush();
        }else{
            CookieSyncManager.createInstance(webView.getContext());
            //清除Cookie
            CookieSyncManager.getInstance().sync();;
        }
    }

    private class FileDownLoadListener implements DownloadListener{
        @Override
        public void onDownloadStart(String url, String userAgent,
                                    String contentDisposition,
                                    String mimetype,
                                    long contentLength) {
            Uri uri=Uri.parse(url);
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }
    }

    public class BaseWebClient extends WebViewClient{
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if(!webView.getSettings().getLoadsImagesAutomatically()){
                webView.getSettings().setLoadsImagesAutomatically(true);
            }
            progressBar.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }
    }
}
