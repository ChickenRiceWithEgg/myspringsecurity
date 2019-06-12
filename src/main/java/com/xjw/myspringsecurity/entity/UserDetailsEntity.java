package com.xjw.myspringsecurity.entity;

import com.xjw.myspringsecurity.dao.GroupMapper;
import com.xjw.myspringsecurity.service.GroupService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 8:55
 */
public class UserDetailsEntity implements UserDetails {

    private String username;

    private String password;

    private List<Group> groups;

    @Resource
    private GroupService groupService;

    public UserDetailsEntity(){
    }

    public UserDetailsEntity(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public UserDetailsEntity(User user, List<Group> groups){
        this.username = user.getUsername();;
        this.password = user.getPassword();
        this.groups = groups;
    }


    /**
     * 返回用户所有角色的封装，一个Group对应一个GrantedAuthority
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Group group : groups){
            grantedAuthorities.add(new SimpleGrantedAuthority(group.getRoleName()));
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    /**
     * 判断账户有没有过期，默认没有过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 判断信用凭证是否过期，默认没有过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断账户有没有锁定，默认没有锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断账户是否可用，默认可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setGroups(List<Group> groups){
        this.groups = groups;
    }

    public List<Group> getGroups(){
        return this.groups;
    }
}
