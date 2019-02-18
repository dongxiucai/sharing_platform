package com.sharing.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

/**
 * HDFS工具类
 */
public class HDFSUtil {

    static Configuration configuration = new Configuration();
    static FileSystem fileSystem = null;

    static {
        try {
            fileSystem = FileSystem.get(new URI("hdfs://mini101:9000/"), configuration, "mini");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向hdfs存入文件
     */
    public static Boolean saveFile(InputStream inputStream, String hdfsPath, String uuidName) {
        try {
            // hdfs输出流
            FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path(hdfsPath + "/" + uuidName));
            // 拷贝文件
            IOUtils.copyBytes(inputStream, fsDataOutputStream, configuration);
            // 关闭输入输出
            IOUtils.closeStream(fsDataOutputStream);
            IOUtils.closeStream(inputStream);
            // 成功
            return true;
        } catch (Exception e) {
            // 失败
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 下载文件，获取输入流
     * @param hdfsPath
     * @param uuidName
     * @return
     * @throws Exception
     */
    public static InputStream downloadFile(String hdfsPath, String uuidName) throws Exception {

        // 输入主机文件
        InputStream inputStream = fileSystem.open(new Path(hdfsPath + "/" + uuidName));
        // 获取输入流
        return inputStream;
    }

}
