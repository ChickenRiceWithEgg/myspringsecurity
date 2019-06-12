package com.xjw.myspringsecurity.service;

import com.xjw.myspringsecurity.entity.User;

import java.util.List;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 8:47
 */
public interface UserService {

    public List<User> findAllUsers();

    public List<User> findByUsername(String username);
}
