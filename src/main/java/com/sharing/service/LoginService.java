package com.sharing.service;

import com.sharing.domain.User;

/**
 * 用户登录service层接口
 */
public interface LoginService {

    /**
     * 用户登陆
      * @param username
     * @param password
     * @return
     */
    public Boolean LoginUser(String username, String password);

    /**
     * 获取用户
     * @param username
     * @return
     */
    public User getUser(String username);
}
