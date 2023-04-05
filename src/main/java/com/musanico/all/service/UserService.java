package com.musanico.all.service;

import com.musanico.all.entity.User;
import com.musanico.all.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public int save(User user){
        if(user.getPolicyId() == null){
            return userMapper.insert(user);
        }else {
            return userMapper.update(user);
        }
    }
}
