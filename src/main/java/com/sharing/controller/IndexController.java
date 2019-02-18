package com.sharing.controller;

import com.sharing.domain.FileDetails;
import com.sharing.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 首页推送
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    IndexService indexService;

    /**
     * 返回首页推送
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        // 返回首页推送
        return "BISHE_index";
    }

    /**
     * 最新上传的前10个
     * @return
     */
    @RequestMapping("/loadNewOptions")
    @ResponseBody
    public List<FileDetails> loadNewOptions(){
        System.out.println("最新上传...");
        List<FileDetails> listNewOptions = indexService.getListNewOptions();
        for(FileDetails f : listNewOptions){
            System.out.println(f.getFileName());
        }

        // String a = "<a href='#' class='list-group-item'>" +listFile[index].filename+ "</a>";

        // 返回给前端页面
        return listNewOptions;
    }

    /**
     * 下载量前10个
     * @return
     */
    @RequestMapping("/loadHotOptions")
    @ResponseBody
    public List<FileDetails> loadHotOptions(){
        System.out.println("最新推荐...");
        List<FileDetails> listHotOptions = indexService.getListHotOptions();
        for(FileDetails f : listHotOptions){
            System.out.println(f.getFileName());
        }
        // 返回给前端页面
        return listHotOptions;
    }

}
