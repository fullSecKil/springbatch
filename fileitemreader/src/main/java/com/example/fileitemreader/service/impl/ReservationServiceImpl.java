package com.example.fileitemreader.service.impl;

import com.example.fileitemreader.dao.ReservationMapper;
import com.example.fileitemreader.pojo.Reservation;
import com.example.fileitemreader.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public Reservation selectById(int id) {
        return reservationMapper.selectById(id);
    }

    @Override
    public List<Reservation> selectReservationByBorder(long start, long end) {
        return this.reservationMapper.selectReservationByBorder(start, end);
    }
}
