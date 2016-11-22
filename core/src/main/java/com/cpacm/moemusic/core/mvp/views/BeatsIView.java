package com.cpacm.moemusic.core.mvp.views;

import com.cpacm.moemusic.core.bean.AccountBean;

/**
 * Created by DIY on 2016/11/21.
 * @desciption: 首页V接口
 */

public interface BeatsIView {
    void setUserDetail(AccountBean accountBean);
    void getUserFail(String msg);
}
