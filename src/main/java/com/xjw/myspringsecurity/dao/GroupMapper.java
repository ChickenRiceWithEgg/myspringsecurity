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

    /**
     * 手写的
     * @param username
     * @return
     */
    List<Group> findGroupsOfUser(String username);

    /**
     * 手写的
     * @param rightId
     * @return
     */
    List<Group> findGroupsOfRight(Integer rightId);
}