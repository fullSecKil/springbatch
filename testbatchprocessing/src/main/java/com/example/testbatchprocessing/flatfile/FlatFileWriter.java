package com.example.testbatchprocessing.flatfile;

import com.example.testbatchprocessing.pojo.People;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @file: FlatFileWriter.class
 * @author: Dusk
 * @since: 2019/5/11 17:59
 * @desc:
 */
@Component("FlatFileWriterDemo")
public class FlatFileWriter implements ItemWriter<People> {

    @Override
    public void write(List<? extends People> items) throws Exception {
        System.out.println("-------------------------------》");
        items.forEach(System.out::println);
    }
}
