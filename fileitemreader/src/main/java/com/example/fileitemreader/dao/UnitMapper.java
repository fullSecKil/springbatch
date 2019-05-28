package com.example.fileitemreader.dao;

import com.example.fileitemreader.pojo.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UnitMapper {
    @Select("select * from Unit where Id=#{id}")
    Unit selectById(int id);
}
