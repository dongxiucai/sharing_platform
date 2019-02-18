package com.sharing.service.impl;

import com.sharing.dao.SearchMapping;
import com.sharing.domain.FileDetails;
import com.sharing.service.SearchService;
import com.sharing.utils.PageBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 全文检索service实现类
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchMapping searchMapping;

    /**
     * 返回结果
     * @param code
     * @param size
     * @return
     */
    @Override
    public PageBean<FileDetails> findByFile(List<Integer> fileids,Integer code, Integer size) {
        List<FileDetails> files = new ArrayList<FileDetails>();
        // 要返回结果
        PageBean<FileDetails> pageBean = new PageBean<FileDetails>();
        // 获取分享个数
        int zong = fileids.size();
        pageBean.setPageCode(code);
        pageBean.setPageSize(size);
        pageBean.setTotalCount(zong);
        pageBean.setTotalPage();

        int i = 0;
        if(code == 1){
            i = 0;
        }else {
            i = (code - 1) * size;
        }

        // 循环
        for(int j = i;j < i+size; j++){
            if(j < zong){
                Integer fileid = fileids.get(j);
                System.out.println("servcefileid: " + fileid);
                // 查询添加
                FileDetails byFile = searchMapping.findByFile(fileid);
                files.add(byFile);
            }
        }
        //
        pageBean.setBeanList(files);
        return pageBean;
    }
}
