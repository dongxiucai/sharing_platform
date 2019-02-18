package com.sharing.service.impl;

import com.sharing.dao.OptionMapping;
import com.sharing.domain.FileDetails;
import com.sharing.service.OptionService;
import com.sharing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类查看service实现类
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionMapping optionMapping;

    /**
     * 查看电影列表
     * @param code
     * @param size
     * @return
     */
    @Override
    public PageBean<FileDetails> getMovie(Integer code, Integer size) {
        int zong = optionMapping.getMovirCount(1);
        PageBean<FileDetails> pageBean = new PageBean<FileDetails>();
        pageBean.setPageCode(code);
        pageBean.setPageSize(size);
        pageBean.setTotalCount(zong);
        pageBean.setTotalPage();

        List<FileDetails> movie = optionMapping.getMovie(1,code == 1 ? 0 : (code - 1) * size, size);
        for(FileDetails file : movie){
            System.out.println(file.getFileName());
        }
        pageBean.setBeanList(movie);
        return pageBean;
    }

    /**
     * 获取音乐列表
     * @param code
     * @param size
     * @return
     */
    @Override
    public PageBean<FileDetails> getMusic(Integer code, Integer size) {
        int zong = optionMapping.getMovirCount(2);
        PageBean<FileDetails> pageBean = new PageBean<FileDetails>();
        pageBean.setPageCode(code);
        pageBean.setPageSize(size);
        pageBean.setTotalCount(zong);
        pageBean.setTotalPage();

        List<FileDetails> music = optionMapping.getMovie(2,code == 1 ? 0 : (code - 1) * size, size);
        for(FileDetails file : music){
            System.out.println(file.getFileName());
        }
        pageBean.setBeanList(music);
        return pageBean;
    }

    /**
     * 获取文档书籍列表
     * @param code
     * @param size
     * @return
     */
    @Override
    public PageBean<FileDetails> getFileOrBook(Integer code, Integer size) {
        int zong = optionMapping.getMovirCount(3);
        PageBean<FileDetails> pageBean = new PageBean<FileDetails>();
        pageBean.setPageCode(code);
        pageBean.setPageSize(size);
        pageBean.setTotalCount(zong);
        pageBean.setTotalPage();

        List<FileDetails> fileorbook = optionMapping.getMovie(3,code == 1 ? 0 : (code - 1) * size, size);
        for(FileDetails file : fileorbook){
            System.out.println(file.getFileName());
        }
        pageBean.setBeanList(fileorbook);
        return pageBean;
    }

    /**
     * 获取其他列表
     * @param code
     * @param size
     * @return
     */
    @Override
    public PageBean<FileDetails> getOther(Integer code, Integer size) {
        int zong = optionMapping.getMovirCount(4);
        PageBean<FileDetails> pageBean = new PageBean<FileDetails>();
        pageBean.setPageCode(code);
        pageBean.setPageSize(size);
        pageBean.setTotalCount(zong);
        pageBean.setTotalPage();

        List<FileDetails> other = optionMapping.getMovie(4,code == 1 ? 0 : (code - 1) * size, size);
        for(FileDetails file : other){
            System.out.println(file.getFileName());
        }
        pageBean.setBeanList(other);
        return pageBean;
    }
}
