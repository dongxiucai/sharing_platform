package com.sharing.service.impl;


import com.sharing.dao.LoginMapping;
import com.sharing.domain.User;
import com.sharing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapping loginMapping;

    // 用户登录
    @Override
    public Boolean LoginUser(String username, String password) {
        // 查询
        int isExist = loginMapping.loginUser(username, password);
        // 判断结果
        if(isExist>0){
            // 此用户存在
            return true;
        }else {
            // 不存在
            return false;
        }
    }

    /**
     * 获取用户
     * @param username
     * @return
     */
    @Override
    public User getUser(String username) {
        User user = loginMapping.getUser(username);
        return user;
    }
}
