package com.sharing.service.impl;

import com.sharing.dao.UpdataMapping;
import com.sharing.domain.FileDetails;
import com.sharing.service.UpdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 下载文件service实现类
 */
@Service
public class UpdataServiceImpl implements UpdataService {

    @Autowired
    UpdataMapping updataMapping;

    /**
     * 通过id查找文件详情
     * @param id
     * @return
     */
    @Override
    public FileDetails getFileDetailsByid(int id) {

        FileDetails fileDetails = updataMapping.getFileDetailsByid(id);

        // 返回数据
        return fileDetails;
    }

    /**
     * 更新下载量
     * @param id
     * @return
     */
    @Override
    public int updataFileCount(int id) {
        // 更新
        int i = updataMapping.updataFileCount(id);
        return i;
    }
}
