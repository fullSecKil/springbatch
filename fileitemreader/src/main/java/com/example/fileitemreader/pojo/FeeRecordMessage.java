package com.example.fileitemreader.pojo;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @file: FeeRecordMessage.class
 * @author: Dusk
 * @since: 2019/5/16 11:15
 * @desc:
 */
@Data
public class FeeRecordMessage {
    private long reservationId;
    private int state;
    private String message;

    public FeeRecordMessage() {
    }

    public FeeRecordMessage(long reservationId, int state, String message) {
        this.reservationId = reservationId;
        this.state = state;
        this.message = message;
    }
}
