package com.example.fileitemreader.service.impl;

import com.example.fileitemreader.dao.UnitMapper;
import com.example.fileitemreader.pojo.Unit;
import com.example.fileitemreader.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    UnitMapper unitMapper;

    @Override
    public Unit selectById(int id) {
        return this.unitMapper.selectById(id);
    }
}
