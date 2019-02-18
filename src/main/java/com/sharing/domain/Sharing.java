package com.sharing.domain;

/**
 * 分享表
 */
public class Sharing {

    private int id; // 唯一主键
    private int userid; // 用户id
    private int fileid; // 文件id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getFileid() {
        return fileid;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }
}
