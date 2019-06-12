package com.xjw.myspringsecurity.dao;

import com.xjw.myspringsecurity.entity.GroupRight;

public interface GroupRightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupRight record);

    int insertSelective(GroupRight record);

    GroupRight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupRight record);

    int updateByPrimaryKey(GroupRight record);
}