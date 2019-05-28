package com.example.fileitemreader.pojo;

import lombok.Data;


/**
 * @file: FeeRecord.class
 * @author: Dusk
 * @since: 2019/5/16 10:52
 * @desc:
 */
@Data
public class FeeRecord {
    private String machineName;
    private double totalAmount;
    private int samplesNumber;
    private String date;
    private String checkInTime;
    private String checkOutTime;
    private String remark;
    private String unit;
    private String payer;

    private String username;
    private String mobile;
    private String email;

    public FeeRecord() {
    }

    public FeeRecord(String machineName, double totalAmount, int samplesNumber, String date, String checkInTime, String checkOutTime, String remark, String unit, String payer, String username, String mobile, String email) {
        this.machineName = machineName;
        this.totalAmount = totalAmount;
        this.samplesNumber = samplesNumber;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.remark = remark;
        this.unit = unit;
        this.payer = payer;
        this.username = username;
        this.mobile = mobile;
        this.email = email;
    }
}
