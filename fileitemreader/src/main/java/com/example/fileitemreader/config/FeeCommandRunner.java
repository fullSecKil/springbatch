package com.example.fileitemreader.config;


import com.example.fileitemreader.scheduled.ScheduledTask;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Log4j2
public class FeeCommandRunner implements CommandLineRunner {
    @Autowired
    @Lazy
    ScheduledTask scheduledTask;

    @Override
    public void run(String... args) throws Exception {
        log.info("hello word");
        // scheduledTask.launcher();
    }
}
