package com.cpacm.moemusic.moe_music1s.presenter;


import com.cpacm.moemusic.core.mvp.presenters.HitokotoIpresenter;
import com.cpacm.moemusic.core.mvp.views.HitokotoIView;

/**
 * Created by DIY on 2016/11/18.
 * @desciption: 一言业务处理
 */

public class HitokotoPresenter implements HitokotoIpresenter {

    private HitokotoIView hitokotoIView;


    public HitokotoPresenter( HitokotoIView hitokotoIView){
        this.hitokotoIView=hitokotoIView;
    }

    public void getKoto(){

    }

    @Override
    public void randKoto(String hitokoto) {
        hitokotoIView.randKoto(hitokoto);
    }
}
