package com.xjw.myspringsecurity.component;

import com.xjw.myspringsecurity.dao.UserMapper;
import com.xjw.myspringsecurity.entity.User;
import com.xjw.myspringsecurity.entity.UserDetailsEntity;
import com.xjw.myspringsecurity.service.GroupService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 11:26
 */
public class MyUseDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private GroupService groupService;

    @Transactional
    public List<User> findAllUsers(){
        List<User> users = userMapper.findAll();
        return users;
    }

    @Transactional
    public List<User> findByUsername(String username) {
        List<User> users = userMapper.findByUsername(username);
        return users;
    }

    /**
     * 重写UserDetailsService接口中的抽象方法
     * 根据用户名，返回一个UserDetails接口实现类UserDetailsEntity的实例
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("查找用户：" + s);
        User user = findByUsername(s).get(0);
        if(user == null){
            throw new UsernameNotFoundException("没有名为："+s+" 的用户");
        }

        //查到User后，将其封装成UserDetails接口实现类UserDetailsEntity的实例，供程序调用
        //用该User和它对应的Group集合构造UserDetailsEntity
        UserDetails userDetails = new UserDetailsEntity(user, groupService.getGroupsOfUser(user.getUsername()));

        return userDetails;
    }
}
