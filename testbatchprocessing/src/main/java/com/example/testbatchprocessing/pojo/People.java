package com.example.testbatchprocessing.pojo;

import lombok.Data;


/**
 * @file: People.class
 * @author: Dusk
 * @since: 2019/5/11 17:37
 * @desc:
 */
@Data
public class People {

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

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", wealth=" + wealth +
                '}';
    }
}
