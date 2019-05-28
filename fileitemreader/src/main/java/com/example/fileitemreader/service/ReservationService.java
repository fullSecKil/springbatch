package com.example.fileitemreader.service;

import com.example.fileitemreader.pojo.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation selectById(int id);
    List<Reservation> selectReservationByBorder(long start, long end);
}
