package com.example.testbatchprocessing.config;

import com.example.testbatchprocessing.scheduled.ScheduledTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @file: CommandRunner.class
 * @author: Dusk
 * @since: 2019/5/12 21:06
 * @desc:
 */

@Component
@Order(1)
public class CommandRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello ever body!");
    }
}
