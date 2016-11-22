package com.cpacm.moemusic.core.mvp.presenters;

import com.cpacm.moemusic.core.bean.AccountBean;

/**
 * Created by DIY on 2016/11/21.
 * @desciption: 首页p接口
 */

public interface BeatsIPresenter {
    void setUserDetail(AccountBean accountBean);
    void getUserFail(String msg);
}
