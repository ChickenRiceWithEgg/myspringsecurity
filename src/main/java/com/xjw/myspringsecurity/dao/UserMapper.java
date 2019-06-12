package com.xjw.myspringsecurity.dao;

import com.xjw.myspringsecurity.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 手写的
     * @return
     */
    List<User> findAll();

    /**
     * 手写的
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

}