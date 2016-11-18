package com.cpacm.moemusic.core.action;

import com.cpacm.moemusic.core.bean.HitokotoBean;
import com.cpacm.moemusic.core.http.HttpUtil;
import com.cpacm.moemusic.core.http.RetrofitManager;
import com.cpacm.moemusic.core.mvp.presenters.HitokotoIpresenter;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DIY on 2016/11/17.
 * @desciption: 获取一言
 */

public class HitokotoAction extends BaseAction {

    private HitokotoService hitokotoService;
    private HitokotoIpresenter presenter;

    public HitokotoAction(HitokotoIpresenter presenter){
        this.presenter=presenter;
        hitokotoService= RetrofitManager.getInstance().getRetrofit()
                .create(HitokotoService.class);
    }

    public void getRandKoto(String cat){
        hitokotoService.getRandKoto(cat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HitokotoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(HitokotoBean hitokotoBean) {
                        presenter.randKoto(hitokotoBean.getHitokoto());
                    }
                });
    }

    public interface HitokotoService{
        //@Headers("Cache-Control:max-age=640000")
        //@Headers("Content-Type:application/json;charset-utf-8")
        @GET(HttpUtil.HITOKOTO_RAND)
        Observable<HitokotoBean> getRandKoto(@Query("cat") String cat);
    }
}
