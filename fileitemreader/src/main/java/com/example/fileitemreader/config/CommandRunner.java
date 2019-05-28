package com.example.fileitemreader.config;

import com.example.fileitemreader.utils.ToCsvUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @file: CommandRunner.class
 * @author: Dusk
 * @since: 2019/5/14 0:58
 * @desc:
 */
@Component
@Order(1)
@Log4j2
public class CommandRunner implements CommandLineRunner {

    @Autowired
    ToCsvUtil toCsvUtil;

    @Override
    public void run(String... args) throws Exception {
        log.info("hello word");
        toCsvUtil.execute();
    }
}
