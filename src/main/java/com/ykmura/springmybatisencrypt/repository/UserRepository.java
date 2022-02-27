package com.ykmura.springmybatisencrypt.repository;

import org.springframework.stereotype.Repository;

import com.ykmura.springmybatisencrypt.model.User;

@Repository
public interface UserRepository {
    User findById(int id);

    User findByIdWithoutDecipher(int id);

    void insert(User user);
}
