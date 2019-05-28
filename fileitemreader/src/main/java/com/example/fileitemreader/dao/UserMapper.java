package com.example.fileitemreader.dao;

import com.example.fileitemreader.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UserMapper {
    @Select("select top(1) * from Users where Name=#{name}")
    User selectByName(String name);
}
