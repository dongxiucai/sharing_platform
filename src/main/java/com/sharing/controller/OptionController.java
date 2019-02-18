package com.sharing.controller;

import com.sharing.domain.FileDetails;
import com.sharing.service.OptionService;
import com.sharing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分类查看
 */
@Controller
@RequestMapping("/option")
public class OptionController {

    @Autowired
    OptionService optionService;

    /**
     * 返回分类查看
     * @return
     */
    @RequestMapping("/toOption")
    public String toOption(){
        // 返回分类查看
        return "BISHE_option";
    }

    /**
     * 获取电影列表
     * @return
     */
    @RequestMapping("/getMovie")
    @ResponseBody
    public PageBean<FileDetails> getMovie(Integer code,Integer size){
        System.out.println("电影...");
        PageBean<FileDetails> movie = optionService.getMovie(code, size);
        return movie;
    }

    /**
     * 获取音乐
     * @return
     */
    @RequestMapping("/getMusic")
    @ResponseBody
    public PageBean<FileDetails> getMusic(Integer code,Integer size){
        System.out.println("音乐...");
        PageBean<FileDetails> music = optionService.getMusic(code, size);
        return music;
    }

    /**
     * 获取文档和书籍
     * @return
     */
    @RequestMapping("/getFileOrBook")
    @ResponseBody
    public PageBean<FileDetails> getFileOrBook(Integer code,Integer size){
        System.out.println("书籍...");
        PageBean<FileDetails> fileorbook = optionService.getFileOrBook(code, size);
        return fileorbook;
    }

    /**
     * 获取其他
     * @return
     */
    @RequestMapping("/getOther")
    @ResponseBody
    public PageBean<FileDetails> getOther(Integer code,Integer size){
        System.out.println("其他...");
        PageBean<FileDetails> other = optionService.getOther(code, size);
        return other;
    }
}
