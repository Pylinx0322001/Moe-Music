package com.cpacm.moemusic.moe_music1s.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cpacm.moemusic.core.oauth.MoefouApi;
import com.cpacm.moemusic.moe_music1s.R;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

import java.io.IOException;

public class OauthActivity extends AppCompatActivity {

    private WebView oauthView;
    OAuth10aService service;
    OAuth1RequestToken requestToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view,"Replace with you own action",Snackbar.LENGTH_LONG)
//                        .setAction("Action",null).show();
                new Thread() {
                    @Override
                    public void run() {
                        startOauth();
                        super.run();
                    }
                }.start();
            }
        });
        oauthView = (WebView) findViewById(R.id.oauth_web);
        oauthView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String v = "";
                String[] ss = url.split("&");
                for (int i = 0; i < ss.length; i++) {
                    if (ss[i].contains("oauth_verifier=")) {
                        String verifier = ss[i].substring(ss[i].indexOf("=") + 1,
                                ss[i].length());
                        if (verifier != null && !verifier.equals("")) {
                            v = verifier;
                            break;
                        }
                    }
                }
                final String vv = v;
                new Thread() {
                    @Override
                    public void run() {
                        final OAuth1AccessToken accessToken;
                        try {
                            accessToken = service
                                    .getAccessToken(requestToken, vv);
                            Log.d("cpacm", accessToken.getToken());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    public void startOauth() {
        service = new ServiceBuilder()
                .apiKey(MoefouApi.ConsumerKey)
                .apiSecret(MoefouApi.ConsumerSecret)
                .callback("http://www.cpacm.net")
                .build(MoefouApi.instance());
        try {
            requestToken = service.getRequestToken();
            Log.d("cpacm", requestToken.toString());
            String authUrl = service.getAuthorizationUrl(requestToken);
            Log.d("cpacm", authUrl);
            startUrl(authUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startUrl(final String url) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                oauthView.loadUrl(url);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

