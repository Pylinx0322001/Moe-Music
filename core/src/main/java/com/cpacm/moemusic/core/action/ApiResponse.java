package com.cpacm.moemusic.core.action;

/**
 * Created by DIY on 2016/11/14.
 * @desciption: 通用的接口数据模板
 */

public class ApiResponse<T> {

    //访问状态
    private int code=CodeUtil.UNKNOWN_ERROR;

    //返回结果（可能为单个对象也可能为对象数组更有可能是特殊对象）
    private T data;

    //服务器返回信息
    private String message;

    //返回结果（可能为单个对象也可能为对象数组更有可能是特殊对象)
    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data=data;
    }

    //获得json数据的状态码
    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code=code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }
}
