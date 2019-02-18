package com.sharing.service;

import com.sharing.domain.FileDetails;
import com.sharing.utils.PageBean;

/**
 * 分类查看service接口
 */
public interface OptionService {

    /**
     * 获取电影列表
     * @param code
     * @param size
     * @return
     */
    public PageBean<FileDetails> getMovie(Integer code, Integer size);

    /**
     * 获取音乐列表
     * @param code
     * @param size
     * @return
     */
    public PageBean<FileDetails> getMusic(Integer code, Integer size);

    /**
     * 获取文档书籍列表
     * @param code
     * @param size
     * @return
     */
    public PageBean<FileDetails> getFileOrBook(Integer code, Integer size);

    /**
     * 获取其他列表
     * @param code
     * @param size
     * @return
     */
    public PageBean<FileDetails> getOther(Integer code, Integer size);
}
