package com.xjw.myspringsecurity.service;

import com.xjw.myspringsecurity.dao.GroupMapper;
import com.xjw.myspringsecurity.entity.Group;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 8:46
 */
@Service
public class GroupServiceImpl implements GroupService{

    @Resource
    GroupMapper groupMapper;

    @Override
    public List<Group> getGroupsOfUser(String username) {
        List<Group> groups = groupMapper.findGroupsOfUser(username);
        return groups;
    }

    @Override
    public List<Group> getGroupsOfRight(Integer rightId) {
        List<Group> groups = groupMapper.findGroupsOfRight(rightId);
        return groups;
    }
}
