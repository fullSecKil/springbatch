package com.example.fileitemreader.service.impl;

import com.example.fileitemreader.dao.UserMapper;
import com.example.fileitemreader.pojo.User;
import com.example.fileitemreader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectByName(String name) {
        return this.userMapper.selectByName(name);
    }
}
