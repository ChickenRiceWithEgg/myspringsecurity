package com.xjw.myspringsecurity.service;

import com.xjw.myspringsecurity.dao.UserMapper;
import com.xjw.myspringsecurity.entity.User;
import com.xjw.myspringsecurity.entity.UserDetailsEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 8:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
