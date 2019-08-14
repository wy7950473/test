package com.example.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
