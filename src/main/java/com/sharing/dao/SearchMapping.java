package com.sharing.dao;

import com.sharing.domain.FileDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 全文检索DAO
 */
@Mapper
public interface SearchMapping {

    /**
     * 获取文件详情
     * @param id
     * @return
     */
    @Select("select * from save_file where id = #{id}")
    public FileDetails findByFile(@Param("id") Integer id);

}
