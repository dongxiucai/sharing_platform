package com.sharing.service;

import java.io.InputStream;

/**
 * 上传文件service接口
 */
public interface InputService {
    /**
     * 分享文件，存入
     * @param inputStream 输入流
     * @param fileName 文件名字
     * @param uuidName 文件唯一id
     * @param optionValue 分类
     * @param summary 简介
     * @return
     */
    public Boolean saveFile(InputStream inputStream,String fileName,String uuidName,String optionValue,String summary,Integer userid);

}
