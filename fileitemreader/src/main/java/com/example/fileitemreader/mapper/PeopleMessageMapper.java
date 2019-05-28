package com.example.fileitemreader.mapper;

import com.example.fileitemreader.pojo.People;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * @file: PeopleMessageMapper.class
 * @author: Dusk
 * @since: 2019/5/11 17:39
 * @desc:
 */

@Component
public class PeopleMessageMapper implements FieldSetMapper<People> {
    @Override
    public People mapFieldSet(FieldSet fieldSet) throws BindException {
        return new People(fieldSet.readString("name")
                , fieldSet.readInt("age")
                , fieldSet.readString("school")
                , fieldSet.readLong("wealth"));
    }
}
