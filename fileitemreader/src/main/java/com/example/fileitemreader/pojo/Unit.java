package com.example.fileitemreader.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @file: Unit.class
 * @author: Dusk
 * @since: 2019/5/17 13:26
 * @desc:
 */
@Data
public class Unit implements Serializable {
    private static final long serialVersionUID = -8231811950038989327L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String sampType;
}
