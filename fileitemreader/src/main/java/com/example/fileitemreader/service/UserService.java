package com.example.fileitemreader.service;

import com.example.fileitemreader.pojo.User;

public interface UserService {
    User selectByName(String name);
}
