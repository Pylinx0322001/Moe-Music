package com.cpacm.moemusic.core.bean.data;

/**
 * Created by DIY on 2016/11/21.
 * @desciption: 通用的接口数据模板
 */

public class ApiResponse<T> {

    private T response;
    public T getResponse(){
        return response;
    }

    public void setResponse(T response){
        this.response=response;
    }
}
