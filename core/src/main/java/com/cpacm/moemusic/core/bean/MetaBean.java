package com.cpacm.moemusic.core.bean;

/**
 * Created by DIY on 2016/11/26.
 * @desciption: meta标签
 */

public class MetaBean {

    /**
     * meta_key:录音
     * meta_value:ERJ
     * meta_type:1
     */

    private String meta_key;
    private String meta_value;
    private int meta_type;

    public String getMeta_key() {
        return meta_key;
    }

    public void setMeta_key(String meta_key) {
        this.meta_key = meta_key;
    }

    public int getMeta_type() {
        return meta_type;
    }

    public void setMeta_type(int meta_type) {
        this.meta_type = meta_type;
    }

    public String getMeta_value() {
        return meta_value;
    }

    public void setMeta_value(String meta_value) {
        this.meta_value = meta_value;
    }
}
