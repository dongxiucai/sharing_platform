package com.sharing.service;

import com.sharing.domain.FileDetails;

import java.util.List;

/**
 * 首页推送service层接口
 */
public interface IndexService {

    /**
     * 最新上传
     * @return
     */
    public List<FileDetails> getListNewOptions();

    /**
     * 最新推荐
     * @return
     */
    public List<FileDetails> getListHotOptions();

}
