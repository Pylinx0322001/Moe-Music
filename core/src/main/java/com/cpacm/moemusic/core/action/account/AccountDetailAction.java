package com.cpacm.moemusic.core.action.account;



import com.cpacm.moemusic.core.action.BaseAction;
import com.cpacm.moemusic.core.bean.data.AccountData;
import com.cpacm.moemusic.core.bean.data.ApiResponse;
import com.cpacm.moemusic.core.http.HttpUtil;
import com.cpacm.moemusic.core.mvp.presenters.BeatsIPresenter;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by DIY on 2016/11/21.
 * @desciption: 用户信息
 */

public class AccountDetailAction extends BaseAction {

    public AccountDetailService detailService;
    private BeatsIPresenter beatsPresenter;
    private Subscriber<ApiResponse<AccountData>> subscriber;

    public AccountDetailAction(BeatsIPresenter bestsPresenter){
        super(HttpUtil.ACCOUNT_DETAIL);
        this.beatsPresenter=bestsPresenter;
        detailService=retrofit.create(AccountDetailService.class);
        subscriber=new Subscriber<ApiResponse<AccountData>>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                AccountDetailAction.this.beatsPresenter
                        .getUserFail(HttpUtil.NETWORK_ERROR);
            }

            @Override
            public void onNext(ApiResponse<AccountData> response) {
                if(response.getResponse().getInformation().isHas_error()){
                    AccountDetailAction.this.beatsPresenter
                            .getUserFail(response.getResponse().getInformation()
                            .getMsg().get(0));
                }else{
                    AccountDetailAction.this.beatsPresenter
                            .setUserDetail(response.getResponse().getUser());
                }
            }
        };
    }

    public void getAccount(){
        detailService.getAccount(authorization)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public void getAccount(int uid){
        authorization=getOauthHeader(url+"?uid="+uid);
        detailService.getAccount(authorization,uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    public void getAccount(String username){
        authorization=getOauthHeader(url+"?user_name="+username);
        detailService.getAccount(authorization,username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    interface AccountDetailService{
        @GET(HttpUtil.ACCOUNT_DETAIL)Observable<ApiResponse<AccountData>>
        getAccount(@Header("Authorization") String authorization);

        @GET(HttpUtil.ACCOUNT_DETAIL)Observable<ApiResponse<AccountData>>
        getAccount(@Header("Authorization") String authorization,
                   @Query("uid") int uid);

        @GET(HttpUtil.ACCOUNT_DETAIL)Observable<ApiResponse<AccountData>>
        getAccount(@Header("Authorization") String authorization,
                   @Query("user_name") String username);

    }
}
