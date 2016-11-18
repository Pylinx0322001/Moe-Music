package com.cpacm.moemusic.core.bean;

/**
 * Created by DIY on 2016/11/17.
 */

public class HitokotoBean {

    /**
     * id;131564987456
     * hitokoto;花朵飘落的速度是五厘米每分钟
     * cat:a
     * catname:动画
     * author:考飞鱼的土豆
     * source:秒速五厘米
     * like:5
     * date:2011.10.15 23:53:03
     */

    private String id;
    private String hitokoto;
    private String cat;
    private String catname;
    private String author;
    private String source;
    private String like;
    private String date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHitokoto() {
        return hitokoto;
    }

    public void setHitokoto(String hitokoto) {
        this.hitokoto = hitokoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
