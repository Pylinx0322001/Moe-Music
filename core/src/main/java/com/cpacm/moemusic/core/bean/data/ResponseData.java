package com.cpacm.moemusic.core.bean.data;

import com.cpacm.moemusic.core.bean.InformationBean;

/**
 * Created by DIY on 2016/11/21.
 */

public class ResponseData<T> {

    public InformationBean<T> information;
    public InformationBean<T> getInformation(){
        return information;
    }

    public void setInformation(InformationBean<T> information){
        this.information=information;
    }
}
