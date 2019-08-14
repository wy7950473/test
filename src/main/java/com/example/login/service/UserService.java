package com.example.login.service;

import com.example.login.pojo.User;
import java.util.List;

public interface UserService {

    List<User> selectAll();

    User selectByNameAndPassword(String username,String password);
}
