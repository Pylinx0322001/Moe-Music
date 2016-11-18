package com.cpacm.moemusic.moe_music1s.presenter;

import com.cpacm.moemusic.core.action.HitokotoAction;
import com.cpacm.moemusic.core.mvp.presenters.HitokotoIpresenter;
import com.cpacm.moemusic.core.mvp.views.HitokotoIView;

/**
 * Created by DIY on 2016/11/18.
 * @desciption: 一言业务处理
 */

public class HitokotoPresenter implements HitokotoIpresenter {

    private HitokotoIView hitokotoIView;
    private HitokotoAction hitokotoAction;

    public HitokotoPresenter( HitokotoIView hitokotoIView){
        this.hitokotoIView=hitokotoIView;
    }

    public void getKoto(){
        hitokotoAction=new HitokotoAction(this);
        hitokotoAction.getRandKoto("a");
    }

    @Override
    public void randKoto(String hitokoto) {
        hitokotoIView.randKoto(hitokoto);
    }
}
