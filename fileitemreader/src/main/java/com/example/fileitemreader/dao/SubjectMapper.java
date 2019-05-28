package com.example.fileitemreader.dao;

import com.example.fileitemreader.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface SubjectMapper {
    @Select("select * from Subject where Id=#{id}")
    Subject selectSubjectById(int id);
}
