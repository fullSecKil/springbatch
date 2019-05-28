package com.example.fileitemreader.processor;

import com.example.fileitemreader.pojo.People;
import com.example.fileitemreader.pojo.ResultMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @file: PeopleProcessor.class
 * @author: Dusk
 * @since: 2019/5/13 23:47
 * @desc:
 */
@Component
public class PeopleProcessor implements ItemProcessor<People, ResultMessage> {
    @Override
    public ResultMessage process(People item) throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setStatus(Optional.ofNullable(item.getSchool()).filter(s -> "外包".equals(s)).map(s1 -> 5).orElse(3));
        resultMessage.setMessage(String.format("%s：%s", item.getSchool(),item.getName()));
        return resultMessage;
    }
}
