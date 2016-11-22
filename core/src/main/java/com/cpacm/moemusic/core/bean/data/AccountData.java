package com.cpacm.moemusic.core.bean.data;

import com.cpacm.moemusic.core.bean.AccountBean;

/**
 * Created by DIY on 2016/11/21.
 * @desciption: 用户信息的数据
 */

public class AccountData extends ResponseData<Object>{
    private AccountBean user;

    public AccountBean getUser(){
        return user;
    }

    public void setUser(AccountBean user){
        this.user=user;
    }

}
