package com.sharing.dao;

import com.sharing.domain.FileDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 下载DAO
 */
@Mapper
public interface UpdataMapping {

    /**
     * 通过id查找详情
     * @param id
     * @return
     */
    @Select("select * from save_file where id = #{id}")
    public FileDetails getFileDetailsByid(@Param("id") int id);

    /**
     * 更新下载量
     * @param id
     * @return
     */
    @Update("update save_file set downloadCount = downloadCount+1 where id = #{id}")
    public int updataFileCount(int id);
}
