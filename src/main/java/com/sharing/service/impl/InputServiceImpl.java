package com.sharing.service.impl;

import com.sharing.dao.InputMapping;
import com.sharing.service.InputService;
import com.sharing.utils.ESUtil;
import com.sharing.utils.HDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Date;

/**
 * 上传文件service实现层
 */
@Service
public class InputServiceImpl implements InputService {


    @Autowired
    InputMapping inputMapping;

    /**
     * 分享文件，存入
     * @param inputStream 输入流
     * @param fileName 文件名字
     * @param uuidName 文件唯一id
     * @param optionValue 分类
     * @param summary 简介
     * @return
     */
    @Override
    public Boolean saveFile(InputStream inputStream, String fileName, String uuidName, String optionValue, String summary,Integer userid) {

        // 存入mysql
        String hdfspath = "/sharing/"+optionValue;
        int filetype =Integer.valueOf(optionValue);

        System.out.println("filename: " + fileName + ",uuidName: " + uuidName + ",optionValue: " + optionValue + ",summary: " + summary);
        Date date = new Date();
        int res = inputMapping.saveFile(fileName, uuidName, hdfspath, summary, filetype, 0,date);
        // 若是存入mysql成功
        if(res > 0){
            // 查询mysql中的唯一id
            int fileid = inputMapping.getIDByuuid(uuidName);
            int i = inputMapping.saveSharing(userid, fileid);
            System.out.println("存入mysql成功！！！！！");
            // 存入hdfs
            Boolean isSuccess = HDFSUtil.saveFile(inputStream, hdfspath, uuidName);
            System.out.println("存入hdfs: " + isSuccess);
            // 若是存入hdfs成功
            if(isSuccess){
                // 存入es
                // 在es中创建索引
                Boolean isSuccess_es = ESUtil.createIndex(fileid, fileName, summary);
                System.out.println("存入es: " + isSuccess_es);
                // 全部存入成功
                return true;
            }
        }

        // 存入失败
        return false;
    }
}
