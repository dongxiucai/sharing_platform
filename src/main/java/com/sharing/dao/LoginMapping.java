package com.sharing.dao;

import com.sharing.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 登陆
 */
@Mapper
public interface LoginMapping {

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @Select("select count(1) from login_user where username = #{username} and password = #{password}")
    public int loginUser(@Param("username") String username,@Param("password") String password);

    /**
     * 获取用户
     * @param username
     * @return
     */
    @Select("select * from login_user where username = #{username}")
    public User getUser(@Param("username") String username);
}
