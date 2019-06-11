package com.xjw.myspringsecurity.dao;

import com.xjw.myspringsecurity.entity.GroupGight;

public interface GroupRightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupGight record);

    int insertSelective(GroupGight record);

    GroupGight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupGight record);

    int updateByPrimaryKey(GroupGight record);
}