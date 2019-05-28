package com.example.testbatchprocessing.task.impl;

import com.example.testbatchprocessing.task.ShopTask;
import org.springframework.stereotype.Component;

/**
 * @file: ShopTaskImpl.class
 * @author: Dusk
 * @since: 2019/5/12 20:41
 * @desc:
 */
@Component
public class ShopTaskImpl implements ShopTask {
    @Override
    public void doTask() {
        System.out.println("task execute");
    }
}
