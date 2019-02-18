package com.sharing.service.impl;

import com.sharing.dao.IndexMapping;
import com.sharing.domain.FileDetails;
import com.sharing.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页推荐service实现类
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexMapping indexMapping;

    /**
     * 获取最新上传的前10个
     * @return
     */
    @Override
    public List<FileDetails> getListNewOptions() {
        // dao
        List<FileDetails> listNewOptions = indexMapping.getListNewOptions();
        // 返回结果
        return listNewOptions;
    }

    /**
     * 获取下载量前10
     * @return
     */
    @Override
    public List<FileDetails> getListHotOptions() {
        // dao
        List<FileDetails> listHotOptions = indexMapping.getListHotOptions();
        // 返回结构
        return listHotOptions;
    }
}
