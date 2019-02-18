package com.sharing.controller;

import com.sharing.domain.FileDetails;
import com.sharing.service.UpdataService;
import com.sharing.utils.HDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/updata")
public class UpdataController {

    @Autowired
    UpdataService updataService;

    /**
     * 跳转到文件详情页面
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/toUpdata")
    public String toUpdata(String id, HttpServletRequest request){
        System.out.println("下载文件页面...");
        System.out.println("id: " + id);
        return "BISHE_updata";
    }

    /**
     * 通过id获取详情
     * @return
     */
    @RequestMapping("/getFileDetails")
    @ResponseBody
    public FileDetails getFileDetails(String id,HttpServletRequest request){
        System.out.println("通过id获取文件详情");

        System.out.println("id: " + id);
        // 通过id获取到详情
        FileDetails fileDetails = updataService.getFileDetailsByid(Integer.valueOf(id));
        //
        return fileDetails;
    }

    /**
     * 下载文件
     * @return
     */
    @RequestMapping("/download")
    public void download(HttpServletResponse response,String id) throws Exception{
        System.out.println("开始下载文件........");
        // 获取文件详情
        FileDetails fileDetails = updataService.getFileDetailsByid(Integer.valueOf(id));
        String hdfsPath = fileDetails.getHdfsPath();
        String uuidName = fileDetails.getUuidName();
        System.out.println("hdfsPath: " + hdfsPath);
        System.out.println("uuidName: " + uuidName);
        //设置文件名
        //设置文件输出头
        response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileDetails.getFileName(), "utf-8"));
        response.setCharacterEncoding("utf-8");

        // 调用HDFSUtil 获取输入流
        InputStream inputStream = HDFSUtil.downloadFile(hdfsPath, uuidName);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        // 循环将输入流中的内容读取到缓冲区中
        while ((len = inputStream.read(buffer)) > 0) {
            // 输出缓冲区内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }

        out.flush();
        inputStream.close();
        out.close();

        // 更改文件下载量
        updataService.updataFileCount(Integer.valueOf(id));
    }


    @RequestMapping("/outTest")
    public void outStudent(HttpServletResponse response) throws Exception{
        String url="D:\\Demo\\hadoop\\input\\py";
        String filename = "test.txt";
        //InputStream inputStream = HDFSUtil.downloadFile("/sharing/4", "1a41a764-f34e-45ac-9f84-02715ae26f2f.png");
        // 下载文件
        // 设置相应头，控制浏览器下载该文件，这里就是会出现当你点击下载后，出现的下载地址框
        response.setHeader("content-disposition", "attachment;filename="+ filename);
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(url + "\\" + filename);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        // 循环将输入流中的内容读取到缓冲区中
        while ((len = in.read(buffer)) > 0) {
            // 输出缓冲区内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        // 刷新
        out.flush();
        // 关闭文件流
        in.close();
        // 关闭输出流
        out.close();
    }

}
