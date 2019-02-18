package com.sharing.service;

import com.sharing.domain.FileDetails;

/**
 * 下载文件service接口
 */
public interface UpdataService {

    /**
     * 通过id查找文件详情
     * @param id
     * @return
     */
    public FileDetails getFileDetailsByid(int id);

    public int updataFileCount(int id);

}
