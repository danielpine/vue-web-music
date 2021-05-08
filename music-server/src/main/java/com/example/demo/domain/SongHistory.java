package com.example.demo.domain;

import java.util.Date;

public class SongHistory {
    private Integer id;

    private Integer userid;

    private Integer count;

    private Integer songid;

    private Date lastplaytime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSongid() {
        return songid;
    }

    public void setSongid(Integer songid) {
        this.songid = songid;
    }

    public Date getLastplaytime() {
        return lastplaytime;
    }

    public void setLastplaytime(Date lastplaytime) {
        this.lastplaytime = lastplaytime;
    }
}