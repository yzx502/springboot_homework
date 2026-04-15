package com.example.springboot_week05.service;

import com.example.springboot_week05.entity.User;
import com.example.springboot_week05.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserTxService {
    private final UserMapper userMapper;


    @Transactional
    public void addTwoUsers(User user1, User user2){
        userMapper.insert(user1);
        if(user2.getUsername() == null || user2.getUsername().isEmpty()){
            throw new RuntimeException("用户2不能为空,事务回滚");
        }
        userMapper.insert(user2);
    }
}
