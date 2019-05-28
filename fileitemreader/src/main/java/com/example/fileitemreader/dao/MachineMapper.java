package com.example.fileitemreader.dao;

import com.example.fileitemreader.pojo.Machine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface MachineMapper {
    @Select("Select * From Machine Where Id=#{id}")
    Machine selectById(int id);
}
