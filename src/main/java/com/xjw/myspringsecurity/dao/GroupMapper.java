package com.xjw.myspringsecurity.dao;

import com.xjw.myspringsecurity.entity.Group;

import java.util.List;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    List<Group> findGroupsOfUser(String username);

    List<Group> findGroupsOfRight(Integer rightId);
}