package com.ykmura.springmybatisencrypt.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
