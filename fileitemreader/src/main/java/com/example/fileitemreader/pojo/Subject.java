package com.example.fileitemreader.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @file: Subject.class
 * @author: Dusk
 * @since: 2019/5/17 11:10
 * @desc:
 */
@Data
public class Subject implements Serializable {
    private static final long serialVersionUID = -3338264894111181351L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int unitId;
    private String payer;
    private String payerEmail;
}
