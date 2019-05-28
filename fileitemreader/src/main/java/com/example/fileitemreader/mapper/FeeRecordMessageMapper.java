package com.example.fileitemreader.mapper;

import com.example.fileitemreader.pojo.FeeRecord;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * @file: FeeRecordMessageMapper.class
 * @author: Dusk
 * @since: 2019/5/16 11:03
 * @desc:
 */

@Component
public class FeeRecordMessageMapper implements FieldSetMapper<FeeRecord> {
    @Override
    public FeeRecord mapFieldSet(FieldSet fieldSet) throws BindException {
        return new FeeRecord(fieldSet.readString("machineName"),
                fieldSet.readDouble("totalAmount"), fieldSet.readInt("samplesNumber"),
                fieldSet.readString("date"), fieldSet.readString("checkInTime"),
                fieldSet.readString("checkOutTime"), fieldSet.readString("remark"),
                fieldSet.readString("unit"), fieldSet.readString("payer"),
                fieldSet.readString("username"), fieldSet.readString("mobile"),
                fieldSet.readString("email"));
    }
}
