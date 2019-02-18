package com.sharing.controller;

import com.sharing.domain.FileDetails;
import com.sharing.service.MySharingService;
import com.sharing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 我的分享
 */
@Controller
@RequestMapping("/mysharing")
public class MySharingController {

    @Autowired
    MySharingService mySharingService;

    /**
     * 跳转到我的详情页面
     * @param id
     * @return
     */
    @RequestMapping("/toMySharing")
    public String toUpdata(String id){
        System.out.println("id: " + id);
        return "BISHE_mysharing";
    }

    /**
     * 查找我的分享
     * @param id 用户id
     * @return
     */
    @RequestMapping("/findByMyFile")
    @ResponseBody
    public PageBean<FileDetails> findByFile(Integer id,Integer code,Integer size){

        System.out.println("我的分享....  " + id + ",code: " + code + ",size: " + size);
        PageBean<FileDetails> mySharing = mySharingService.getMySharing(id, code, size);

        return mySharing;
    }

}
