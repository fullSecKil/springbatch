package com.example.fileitemreader.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @file: Reservation.class
 * @author: Dusk
 * @since: 2019/5/17 10:51
 * @desc:
 */
@Data
@Table(name = "Reservation")
public class Reservation implements Serializable {
    private static final long serialVersionUID = -7022722696575635665L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int machineId;
    private int subjectId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date checkInTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date checkOutTime;

    private int machineFee;
    private int materialFee;
    private int otherFee;
}
