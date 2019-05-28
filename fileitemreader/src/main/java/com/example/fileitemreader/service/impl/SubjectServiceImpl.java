package com.example.fileitemreader.service.impl;

import com.example.fileitemreader.dao.SubjectMapper;
import com.example.fileitemreader.pojo.Subject;
import com.example.fileitemreader.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;
    @Override
    public Subject selectSubjectById(int id) {
        return subjectMapper.selectSubjectById(id);
    }
}
