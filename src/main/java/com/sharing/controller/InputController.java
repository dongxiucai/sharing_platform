package com.sharing.controller;

import com.sharing.service.InputService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 上传文件
 */
@RequestMapping("/input")
@Controller
public class InputController {

    @Autowired
    InputService inputService;

    /**
     * 跳转input页面
     * @return
     */
    @RequestMapping(value = "/toInput")
    public String toInput(Integer id, HttpServletRequest request){
        System.out.println("id: " + id);
        request.getSession().setAttribute("userid",id);
        // 跳转input页面
        return "BISHE_input";
    }

    /**
     * 上传分享文件
     * @param inputfile
     * @param options
     * @param summary
     */
    @RequestMapping("inputfile")
    public String inputFile(MultipartFile inputfile,String options,String summary,HttpServletRequest request) throws IOException {
        System.out.println("上传文件......");
        // 获取文件名字
        String filename = inputfile.getOriginalFilename();
        // HDFS唯一名字
        String uuidName = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
        // 获取文件的输入流
        InputStream inputStream = inputfile.getInputStream();
        // 简记为空
        if(summary.equals("")){
            summary = "暂无简介...";
        }
        System.out.println("filename: " + filename);
        System.out.println("uuidname: " + uuidName);
        System.out.println("options: " + options);
        System.out.println("summary: " + summary);
        // 调用service层
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        System.out.println("userid: ======= " + userid);
        Boolean isSuccess = inputService.saveFile(inputStream,filename, uuidName,options,summary,userid);
        if(isSuccess){
            return "BISHE_success";
        }else {
            return "BISHE_error";
        }


    }

}
