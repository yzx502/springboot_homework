package com.example.springboot_week05.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_week05.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectByCondition(Map<String, Object> params);

    int batchInsert(@Param("users") List<User> users);

    int batchDelete(@Param("ids") List<Long> ids);

    int updateSelective(User user);

    List<User> selectByChoice(@Param("searchType") String searchType, 
                              @Param("searchValue") String searchValue);

    IPage<User> selectPageWithCondition(Page<User> page, @Param("params") Map<String, Object> params);
}
