package com.example.fileitemreader.writer;

import com.example.fileitemreader.pojo.ResultMessage;
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
public class FlatFileWriter implements ItemWriter<ResultMessage> {

    @Override
    public void write(List<? extends ResultMessage> items) throws Exception {
        items.forEach(System.out::println);
    }
}
