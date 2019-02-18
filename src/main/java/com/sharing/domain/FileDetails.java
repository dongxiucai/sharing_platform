package com.sharing.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件详情domain
 */
public class FileDetails {

    private int id; // id
    private String fileName; // 文件名
    private String uuidName; // uuidname
    private String hdfsPath; // hdfs存储地址
    private String summary; // 文件简介
    private int filType; // 文件类型
    private int downloadCount; // 文件下载次数
    private Date input_time; // 文件上传时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUuidName() {
        return uuidName;
    }

    public void setUuidName(String uuidName) {
        this.uuidName = uuidName;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getFilType() {
        return filType;
    }

    public void setFilType(int filType) {
        this.filType = filType;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Date getInput_time() {
        return input_time;
    }

    public String getFormatTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(input_time);
        return format;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
    }


}
