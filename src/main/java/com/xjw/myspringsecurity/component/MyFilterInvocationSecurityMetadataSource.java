package com.xjw.myspringsecurity.component;

import com.xjw.myspringsecurity.entity.Group;
import com.xjw.myspringsecurity.entity.Right;
import com.xjw.myspringsecurity.service.GroupService;
import com.xjw.myspringsecurity.service.RightService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 10:11
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private RightService rightService;

    @Resource
    private GroupService groupService;

    /**
     * 接受用户请求的地址，返回访问该地址所需要的权限
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //得到用户的请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("用户的请求地址是：" + requestUrl);

        //如果是登录页面，则不需要权限
        if("/login".equals(requestUrl)){
            return null;
        }

        //通过请求地址，得到对应的权限
        Right right = rightService.getRightByUrl(requestUrl);

        //如果请求路径没有对应的权限，即right为空，则任何人都可以访问
        if(right == null){
            return SecurityConfig.createList("ROLE_LOGIN");
        }

        //返回拥有该请求路径对应的权限的所有角色
        List<Group> groups = groupService.getGroupsOfRight(right.getId());
        int size = groups.size();
        String[] values = new String[size];
        for(int i=0; i<size; i++){
            values[i] = groups.get(i).getRoleName();
        }
        return SecurityConfig.createList(values);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
