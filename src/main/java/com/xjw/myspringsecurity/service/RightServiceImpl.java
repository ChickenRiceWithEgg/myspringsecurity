package com.xjw.myspringsecurity.service;

import com.xjw.myspringsecurity.dao.RightMapper;
import com.xjw.myspringsecurity.entity.Right;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 9:39
 */
@Service
public class RightServiceImpl implements RightService {

    @Resource
    private RightMapper rightMapper;

    @Override
    public Right getRightByUrl(String url) {
        Right right = rightMapper.findByUrl(url).get(0);
        return right;
    }
}
