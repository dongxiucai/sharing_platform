package com.sharing.service.impl;

import com.sharing.dao.MySharingMapping;
import com.sharing.domain.FileDetails;
import com.sharing.domain.Sharing;
import com.sharing.service.MySharingService;
import com.sharing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的分享service实现类
 */
@Service
public class MySharingServiceImpl implements MySharingService {

    @Autowired
    MySharingMapping mySharingMapping;

    /**
     * 查看用户分享列表
     * @param code
     * @param size
     * @return
     */
    @Override
    public PageBean<FileDetails> getMySharing(Integer userid, Integer code, Integer size) {
        // 要返回的集合
        List<FileDetails> mysharing = new ArrayList<FileDetails>();
        // 获取分享表中的文件id
        List<Sharing> sharing = mySharingMapping.getSharing(userid,code == 1 ? 0 : (code - 1) * size, size);
        // 循环
        for(Sharing shr : sharing){
            int fileid = shr.getFileid();
            FileDetails myFile = mySharingMapping.getMyFile(fileid);
            System.out.println("我的分享：" + myFile.getFileName());
            // 添加文件
            mysharing.add(myFile);
        }

        // 获取分享个数
        int zong = mySharingMapping.getCount(userid);
        PageBean<FileDetails> pageBean = new PageBean<FileDetails>();
        pageBean.setPageCode(code);
        pageBean.setPageSize(size);
        pageBean.setTotalCount(zong);
        pageBean.setTotalPage();
        //
        pageBean.setBeanList(mysharing);
        return pageBean;
    }

}
