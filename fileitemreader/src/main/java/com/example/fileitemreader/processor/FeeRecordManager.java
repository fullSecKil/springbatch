package com.example.fileitemreader.processor;

import com.example.fileitemreader.pojo.*;
import com.example.fileitemreader.service.MachineService;
import com.example.fileitemreader.service.ReservationService;
import com.example.fileitemreader.service.SubjectService;
import com.example.fileitemreader.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class FeeRecordManager {
    @Autowired
    ReservationService reservationService;
    @Autowired
    MachineService machineService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    UnitService unitService;

    public FeeRecordMessage feeRecordEntrance(FeeRecord feeRecord) {
        return Optional.ofNullable(feeRecord).map(this::handler).orElse(new FeeRecordMessage(0, 0, "无支付记录存在"));
    }

    // Handler
    public FeeRecordMessage handler(FeeRecord feeRecord) {
        FeeRecord nativeFeeRecord = feeRecord;
        Map<String, String> remark = Arrays.stream(nativeFeeRecord.getRemark().split("，")).collect(Collectors.toMap(r -> r.split(":")[0], r -> r.split(":")[1]));
        int feeRecordId = Integer.parseInt(remark.get("预定id"));
        // System.out.println("预定id:" + feeRecordId);
        Reservation reservation = reservationService.selectById(feeRecordId);

        FeeRecordMessage feeRecordMessage = new FeeRecordMessage(reservation.getId(), 5, "通过测试");
        if (!Optional.ofNullable(reservation).filter(r -> remark.get("机器费").equals(String.valueOf(r.getMachineFee())) && remark.get("材料费").equals(String.valueOf(r.getMaterialFee())) && remark.get("其他费").equals(String.valueOf(r.getOtherFee()))
        ).isPresent()) {
            feeRecordMessage.setState(1);
            feeRecordMessage.setMessage("预定表记录不存在或费用错误!");
            return feeRecordMessage;
        }
        if (!Optional.ofNullable(machineService.selectById(reservation.getMachineId())).map(Machine::getSampName).filter(n -> n.equals(nativeFeeRecord.getMachineName())).isPresent()) {
            feeRecordMessage.setState(2);
            feeRecordMessage.setMessage("无对应关系的预定设备记录!");
            return feeRecordMessage;
        }

        Subject subject = subjectService.selectSubjectById(reservation.getSubjectId());
        if (!Optional.ofNullable(subject).filter(r -> r.getName().equals(remark.get("课题")) && r.getPayerEmail().equals(nativeFeeRecord.getEmail())).isPresent()) {
            feeRecordMessage.setState(3);
            feeRecordMessage.setMessage("课题属性对应异常");
            return feeRecordMessage;
        }
        // System.out.println(unitService.selectById(subject.getUnitId()).getSampType());
        // System.out.println(nativeFeeRecord.getUnit());
        if (!Optional.ofNullable(unitService.selectById(subject.getUnitId())).filter(u -> u.getSampType().equals(nativeFeeRecord.getUnit()) && u.getName().equals(remark.get("单位"))).isPresent()) {
            feeRecordMessage.setState(4);
            feeRecordMessage.setMessage("单位不存在，或单位属性对应异常");
            return feeRecordMessage;
        }

        return feeRecordMessage;
    }
}
