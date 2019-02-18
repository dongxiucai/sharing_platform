package com.sharing.dao;

import com.sharing.domain.FileDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 首页推荐DAO层
 */
@Mapper
public interface IndexMapping {

    /**
     * 最新上传的前10个
     * @return
     */
    @Select("select * from save_file order by input_time desc limit 0,10")
    public List<FileDetails> getListNewOptions();

    /**
     * 下载量前10个
     * @return
     */
    @Select("select * from save_file order by downloadCount desc limit 0,10")
    public List<FileDetails> getListHotOptions();
}
