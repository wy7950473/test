package com.example.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.login.dao.UserDao;
import com.example.login.pojo.User;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll() {
        List<User> list = this.userDao.selectList(null);
        return list;
    }

    @Override
    public User selectByNameAndPassword(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(User::getUsername,username).eq(User::getPassword,password);
        return this.userDao.selectOne(queryWrapper);
    }
}
