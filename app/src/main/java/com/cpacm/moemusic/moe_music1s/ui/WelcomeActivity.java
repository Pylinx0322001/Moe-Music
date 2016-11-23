package com.cpacm.moemusic.moe_music1s.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.cpacm.moemusic.core.cache.SettingManager;
import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.ui.bests.BeatsActivity;
import com.cpacm.moemusic.moe_music1s.ui.login.LoginActivity;

/**
 * Created by DIY on 2016/11/16.
 */

public class WelcomeActivity extends AbstractAppActivity {

    private ImageView welcomeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeView=(ImageView)findViewById(R.id.logo);
        startAnimation();
    }

    public void startAnimation(){
        ObjectAnimator scalXAnimator=ObjectAnimator.ofFloat(welcomeView,"scaleX",0f,1f);
        ObjectAnimator scalYAnimator=ObjectAnimator.ofFloat(welcomeView,"scaleY",0f,1f);
        ObjectAnimator alphaAnimator=ObjectAnimator.ofFloat(welcomeView,"alpha",0f,1f);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(alphaAnimator).with(scalXAnimator).with(scalYAnimator);
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
//                startBeatsActivity();
                hasLogin();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }
        });
    }
//    public void startBeatsActivity(){
//        Intent i=new Intent();
//        i.setClass(this, LoginActivity.class);
//        startActivity(i);
//        finish();
//    }
    public void hasLogin(){
//        if(TextUtils.isEmpty(SettingManager.getInstance()
//                .getSetting(SettingManager.ACCESS_TOKEN))){
        if(SettingManager.getInstance()
                .getSetting(SettingManager.ACCOUNT_ID,-1)==-1){
            startActivity(LoginActivity.class);
        }else{
            startActivity(BeatsActivity.class);
            finish();
        }
    }
}
