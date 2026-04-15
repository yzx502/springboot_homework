package com.example.springboot_week05.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot_week05.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<User> {

    List<User> getByCondition(Map<String, Object> params);
    
    boolean batchSave(List<User> users);
    
    boolean batchDelete(List<Long> ids);
    
    boolean updateSelective(User user);
    
    List<User> searchByType(String searchType, String searchValue);
    
    IPage<User> getPageWithCondition(int current, int size, Map<String, Object> params);
    
    boolean saveWithTransaction(User user);
    
    void transferDemo(Long fromId, Long toId, int amount);
}
