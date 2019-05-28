package com.example.fileitemreader.dao;

import com.example.fileitemreader.pojo.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


@Mapper
@Transactional(rollbackFor = Exception.class)
public interface ReservationMapper {

    @Select("select * from Reservation where Id=#{id}")
    Reservation selectById(int id);

    @Select("select * from Reservation where State=5 and Id > #{start} and Id <=#{end} order by Id")
    List<Reservation> selectReservationByBorder(long start, long end);

}
