package com.xjw.myspringsecurity.dao;

import com.xjw.myspringsecurity.entity.Right;

import java.util.List;

public interface RightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Right record);

    int insertSelective(Right record);

    Right selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);

    /**
     * 这是手写的
     * @param url
     * @return
     */
    List<Right> findByUrl(String url);
}