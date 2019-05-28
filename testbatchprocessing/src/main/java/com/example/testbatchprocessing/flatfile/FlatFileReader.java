package com.example.testbatchprocessing.flatfile;

import com.example.testbatchprocessing.pojo.People;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @file: FlatFileReader.class
 * @author: Dusk
 * @since: 2019/5/12 1:39
 * @desc:
 */
@Component("FlatFileReadDemo2")
public class FlatFileReader implements ItemReader<People> {
    @Override
    public People read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        // return Arrays.asList(new People("薛瑞", 23, "外包", 500), new People("丁志伟", 23, "南中医", 600), new People("ch", 23, "scpd", 500));
        return new People("薛瑞", 23, "外包", 500);
    }
}
