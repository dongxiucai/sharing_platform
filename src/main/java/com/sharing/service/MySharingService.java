package com.sharing.service;

import com.sharing.domain.FileDetails;
import com.sharing.utils.PageBean;

/**
 * 我的分享service接口
 */
public interface MySharingService {

    /**
     * 查找我的分享
     * @param userid
     * @param code
     * @param size
     * @return
     */
    public PageBean<FileDetails> getMySharing(Integer userid, Integer code, Integer size);

}
