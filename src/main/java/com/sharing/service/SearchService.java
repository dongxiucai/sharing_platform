package com.sharing.service;

import com.sharing.domain.FileDetails;
import com.sharing.utils.PageBean;

import java.util.List;

/**
 * 全文检索service接口
 */
public interface SearchService {

    public PageBean<FileDetails> findByFile(List<Integer> fileids, Integer code, Integer size);

}
