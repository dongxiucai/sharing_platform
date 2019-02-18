package com.sharing.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sharing.domain.FileDetails;
import com.sharing.service.SearchService;
import com.sharing.utils.ESUtil;
import com.sharing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 全文检索
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    static String searchText = ""; // 全文检索的字符串

    @Autowired
    SearchService searchService;

    /**
     * 跳转到页面
     * @return
     */
    @RequestMapping("/toSearch")
    public String toSearch(String search){
        searchText = search;
        System.out.println("tosearch: " + searchText);
        // 返回页面
        return "BISHE_search";
    }

    /**
     * 全文检索，分页查看
     * @return
     */
    @RequestMapping("/findSearch")
    @ResponseBody
    public PageBean<FileDetails> findByFile(Integer code, Integer size){

        System.out.println("search: " + searchText);

        // 调用ESUtil
        List<Integer> fileids = ESUtil.queryIndex(searchText);
        for(Integer i : fileids){
            System.out.println(i);
        }

        PageBean<FileDetails> byFile = searchService.findByFile(fileids, code, size);

        return byFile;
        //return null;
    }


}
