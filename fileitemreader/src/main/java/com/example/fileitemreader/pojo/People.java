package com.example.fileitemreader.pojo;

import lombok.Data;

import java.io.Serializable;


/**
 * @file: People.class
 * @author: Dusk
 * @since: 2019/5/11 17:37
 * @desc:
 */
@Data
public class People implements Serializable {

    private static final long serialVersionUID = -2317728821791965886L;

    private String name;
    private int age;
    private String school;
    private long wealth;

    public People() {
    }

    public People(String name, int age, String school, long wealth) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.wealth = wealth;
    }
}
