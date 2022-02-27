package com.ykmura.springmybatisencrypt.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ykmura.springmybatisencrypt.model.User;

@Mapper
public interface UserRepository {
    User findById(int id);

    void insert(User user);
}
