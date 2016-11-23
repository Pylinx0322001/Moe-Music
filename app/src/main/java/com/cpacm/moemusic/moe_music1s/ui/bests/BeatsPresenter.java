package com.cpacm.moemusic.moe_music1s.ui.bests;

import com.cpacm.moemusic.core.action.account.AccountDetailAction;
import com.cpacm.moemusic.core.bean.AccountBean;
import com.cpacm.moemusic.core.cache.SettingManager;
import com.cpacm.moemusic.core.db.dao.AccountDao;
import com.cpacm.moemusic.core.mvp.presenters.BeatsIPresenter;
import com.cpacm.moemusic.core.mvp.views.BeatsIView;
import com.cpacm.moemusic.moe_music1s.MoeApplication;

/**
 * Created by DIY on 2016/11/22.
 * @desciption: 主页逻辑处理
 */

public class BeatsPresenter implements BeatsIPresenter {

    private BeatsIView beatsIView;
    private AccountDetailAction detailAction;

    public BeatsPresenter(BeatsIView beatsView){
        this.beatsIView=beatsView;
        detailAction=new AccountDetailAction(this);
    }

    public void getAccountDetail(){
        detailAction.getAccount();
    }

    @Override
    public void getUserFail(String msg) {
       beatsIView.getUserFail(msg);
    }

    @Override
    public void setUserDetail(AccountBean accountBean) {
        beatsIView.setUserDetail(accountBean);
        SettingManager.getInstance().
                setSetting(SettingManager.ACCOUNT_ID,accountBean.getUid());
        MoeApplication.getInstance().setAccountBean(accountBean);
        AccountDao accountDao=new AccountDao();
        accountDao.updateAccount(accountBean);
        accountDao.close();
    }
}
