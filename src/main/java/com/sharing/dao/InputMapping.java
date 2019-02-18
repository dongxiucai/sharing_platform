package com.sharing.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;


/**
 * 上传文件dao层
 */
@Mapper
public interface InputMapping {

    /**
     * 插入文件信息
     * @param filename
     * @param uuidname
     * @param hdfspath
     * @param summary
     * @param filetype
     * @param downloadCount
     * @return
     */
    @Insert("insert into save_file (filename,uuidname,hdfspath,summary,filetype,downloadCount,input_time) values (#{filename}," +
            "#{uuidname},#{hdfspath},#{summary},#{filetype},#{downloadCount},#{input_time})")
    public int saveFile(@Param("filename") String filename, @Param("uuidname") String uuidname,
                        @Param("hdfspath") String hdfspath, @Param("summary") String summary, @Param("filetype") int filetype,
                        @Param("downloadCount") int downloadCount, @Param("input_time") Date input_time);


    @Select("select id from save_file where uuidname = #{uuidname}")
    public int getIDByuuid(@Param("uuidname") String uuidname);

    /**
     * 插入分享表
     * @param userid
     * @param fileid
     * @return
     */
    @Insert("insert into sharing (userid,fileid) values (#{userid},#{fileid})")
    public int saveSharing(@Param("userid") Integer userid,@Param("fileid") Integer fileid);
}
