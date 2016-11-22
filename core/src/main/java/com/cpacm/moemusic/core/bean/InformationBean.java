package com.cpacm.moemusic.core.bean;

import java.util.List;

/**
 * Created by DIY on 2016/11/21.
 * @desciption: 接口返回信息
 */

public class InformationBean<T> {

    /**
     * parameters:null
     * msg:[]
     * has_error:false
     * error:0
     * request:/user/detail_json
     */

    private T parameters;
    private boolean has_error;
    private int error;
    private String request;
    private List<String> msg;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public boolean isHas_error() {
        return has_error;
    }

    public void setHas_error(boolean has_error) {
        this.has_error = has_error;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public T getParameters() {
        return parameters;
    }

    public void setParameters(T parameters) {
        this.parameters = parameters;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
