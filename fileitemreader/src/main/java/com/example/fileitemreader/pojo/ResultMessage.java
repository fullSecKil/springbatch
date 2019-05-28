package com.example.fileitemreader.pojo;

import lombok.Data;

/**
 * @file: ResultMessage.class
 * @author: Dusk
 * @since: 2019/5/13 23:48
 * @desc:
 */
@Data
public class ResultMessage {
    private int status;
    private String name;
    private String message;
}
