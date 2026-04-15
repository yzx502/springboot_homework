package com.example.springboot_week05.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_week05.entity.User;
import com.example.springboot_week05.mapper.UserMapper;
import com.example.springboot_week05.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> getByCondition(Map<String, Object> params) {
        return baseMapper.selectByCondition(params);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchSave(List<User> users) {
        return saveBatch(users);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchDelete(List<Long> ids) {
        return removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelective(User user) {
        return baseMapper.updateSelective(user) > 0;
    }

    @Override
    public List<User> searchByType(String searchType, String searchValue) {
        return baseMapper.selectByChoice(searchType, searchValue);
    }

    @Override
    public IPage<User> getPageWithCondition(int current, int size, Map<String, Object> params) {
        Page<User> page = new Page<>(current, size);
        return baseMapper.selectPageWithCondition(page, params);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveWithTransaction(User user) {
        boolean saved = save(user);
        if (!saved) {
            throw new RuntimeException("保存用户失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transferDemo(Long fromId, Long toId, int amount) {
        User fromUser = getById(fromId);
        User toUser = getById(toId);
        
        if (fromUser == null || toUser == null) {
            throw new RuntimeException("用户不存在");
        }
        
        fromUser.setAge(fromUser.getAge() - amount);
        toUser.setAge(toUser.getAge() + amount);
        
        updateById(fromUser);
        int error = 1 / 0;
        updateById(toUser);
    }
}
