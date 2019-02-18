package com.sharing.dao;

import com.sharing.domain.FileDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.security.PublicKey;
import java.util.List;

/**
 * 分类查看DAO
 */
@Mapper
public interface OptionMapping {

    /**
     * 查找电影列表
     * @param start
     * @param size
     * @return
     */
    @Select("select * from save_file where filetype = #{type} limit #{start},#{size}")
    public List<FileDetails> getMovie(@Param("type") Integer type, @Param("start") Integer start, @Param("size") Integer size);

    @Select("select count(1) from save_file where filetype = #{type}")
    public int getMovirCount(@Param("type") Integer type);


}
