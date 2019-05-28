package com.example.fileitemreader.processor;

import com.example.fileitemreader.pojo.FeeRecord;
import com.example.fileitemreader.pojo.FeeRecordMessage;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @file: FeeRecordProcessor.class
 * @author: Dusk
 * @since: 2019/5/16 11:21
 * @desc: 费用处理器
 */
@Component
public class FeeRecordProcessor implements ItemProcessor<FeeRecord, FeeRecordMessage> {

    private FeeRecordManager feeRecordManager;

    @Autowired
    public void setFeeRecordManager(FeeRecordManager feeRecordManager) {
        this.feeRecordManager = feeRecordManager;
    }

    @Override
    public FeeRecordMessage process(FeeRecord item) throws Exception {
        return feeRecordManager.feeRecordEntrance(item);
    }
}
