package com.example.fileitemreader.writer;

import com.example.fileitemreader.pojo.FeeRecordMessage;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;

/**
 * @file: FeeRecordWriter.class
 * @author: Dusk
 * @since: 2019/5/16 14:44
 * @desc:
 */
@Component
public class FeeRecordWriter implements ItemWriter<FeeRecordMessage> {
    @Override
    public void write(List<? extends FeeRecordMessage> items) throws Exception {

        // items.forEach(System.out::println);

        File resultFile = new File(ResourceUtils.getFile("classpath:data/init"), String.format("%s.%s", "result", "txt"));
        if (!resultFile.exists()) {
            try {
                resultFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(resultFile, true));
        items.stream().filter(f->((FeeRecordMessage) f).getState()!=5).forEach(f->{
            try {
                bos.write((f+"\r\n").toString().getBytes("utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bos.flush();
        bos.close();
    }
}
