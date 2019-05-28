package com.example.fileitemreader.service.impl;

import com.example.fileitemreader.dao.MachineMapper;
import com.example.fileitemreader.dao.UserMapper;
import com.example.fileitemreader.pojo.Machine;
import com.example.fileitemreader.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineServiceImpl implements MachineService {
    private MachineMapper machineMapper;

    @Autowired
    public void setMachineMapper(MachineMapper machineMapper) {
        this.machineMapper = machineMapper;
    }

    @Override
    public Machine selectById(int id) {
        return this.machineMapper.selectById(id);
    }
}
