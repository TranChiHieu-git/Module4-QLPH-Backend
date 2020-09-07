package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.Role;
import com.codegym.meeting_room_management.dao.entity.User;
import com.codegym.meeting_room_management.dao.repository.UserRepositoryHaiKS;
import com.codegym.meeting_room_management.service.UserServiceHaiKS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserServiceHaiKSImpl implements UserDetailsService {
    @Autowired
    UserRepositoryHaiKS userRepositoryHaiKS;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        User user = userRepositoryHaiKS.findAllByUsername(accountName);
        if (user == null) {
            throw new UsernameNotFoundException("Không thể tìm thấy tên đăng nhập: " + accountName);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role role = user.getRole();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }


}