package com.xjw.myspringsecurity.service;

import com.xjw.myspringsecurity.entity.Group;

import java.util.List;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 8:47
 */
public interface GroupService {

    public List<Group> getGroupsOfUser(String username);

    public List<Group> getGroupsOfRight(Integer rightId);
}
