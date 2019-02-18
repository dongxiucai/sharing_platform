package com.sharing.dao;

import com.sharing.domain.FileDetails;
import com.sharing.domain.Sharing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 我的分享DAO层
 */
@Mapper
public interface MySharingMapping {

    /**
     * 查找我的文件
     * @param fileid 文件id
     * @return
     */
    @Select("select * from save_file where id = #{fileid}")
    public FileDetails getMyFile(@Param("fileid") Integer fileid);

    /**
     * 文件的个数
     * @param userid
     * @return
     */
    @Select("select count(1) from sharing where userid = #{userid}")
    public int getCount(@Param("userid") Integer userid);

    /**
     * 查找用户的分享列表
     * @param id
     * @return
     */
    @Select("select * from sharing  where userid = #{userid}  limit #{start},#{size}")
    public List<Sharing> getSharing(@Param("userid") Integer id, @Param("start") Integer start, @Param("size") Integer size);


}
