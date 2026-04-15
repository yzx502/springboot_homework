package com.example.springboot_week05.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot_week05.common.Result;
import com.example.springboot_week05.entity.User;
import com.example.springboot_week05.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "用户管理", description = "用户 CRUD 相关接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "新增用户", description = "创建一个新用户")
    @PostMapping
    public Result<Boolean> addUser(@RequestBody User user){
        boolean result = userService.save(user);
        return Result.success(result);
    }

    @Operation(summary = "根据 ID 查询用户", description = "通过主键 ID 查询用户信息")
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id){
        User user = userService.getById(id);
        return Result.success(user);
    }

    @Operation(summary = "查询所有用户", description = "获取所有用户列表")
    @GetMapping("/list")
    public Result<List<User>> getAllUsers(){
        List<User> users = userService.list();
        return Result.success(users);
    }

    @Operation(summary = "更新用户信息", description = "根据 ID 更新用户信息")
    @PutMapping
    public Result<Boolean> updateUser(@RequestBody User user){
        boolean result = userService.updateById(user);
        return Result.success(result);
    }

    @Operation(summary = "删除用户", description = "根据 ID 删除用户")
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteUser(@PathVariable Long id){
        boolean result = userService.removeById(id);
        return Result.success(result);
    }

    @Operation(summary = "多条件查询", description = "根据用户名、年龄范围等条件查询")
    @GetMapping("/search")
    public Result<List<User>> searchUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String email) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("minAge", minAge);
        params.put("maxAge", maxAge);
        params.put("email", email);
        
        List<User> users = userService.getByCondition(params);
        return Result.success(users);
    }

    @Operation(summary = "批量新增用户", description = "一次性创建多个用户")
    @PostMapping("/batch")
    public Result<Boolean> batchAddUsers(@RequestBody List<User> users){
        boolean result = userService.saveBatch(users);
        return Result.success(result);
    }

    @Operation(summary = "批量删除用户", description = "一次性删除多个用户")
    @DeleteMapping("/batch")
    public Result<Boolean> batchDeleteUsers(@RequestBody List<Long> ids){
        boolean result = userService.removeByIds(ids);
        return Result.success(result);
    }

    @Operation(summary = "选择性更新", description = "只更新传入的字段")
    @PatchMapping
    public Result<Boolean> updateSelective(@RequestBody User user){
        boolean result = userService.updateSelective(user);
        return Result.success(result);
    }

    @Operation(summary = "按类型搜索", description = "根据搜索类型和值查询")
    @GetMapping("/searchByType")
    public Result<List<User>> searchByType(
            @RequestParam String searchType,
            @RequestParam String searchValue) {
        List<User> users = userService.searchByType(searchType, searchValue);
        return Result.success(users);
    }

    @Operation(summary = "分页查询", description = "带条件的分页查询")
    @GetMapping("/page")
    public Result<IPage<User>> getUsersByPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("minAge", minAge);
        params.put("maxAge", maxAge);
        
        IPage<User> page = userService.getPageWithCondition(current, size, params);
        return Result.success(page);
    }

    @Operation(summary = "条件构造器查询", description = "使用 QueryWrapper 动态构建查询条件")
    @GetMapping("/wrapper")
    public Result<List<User>> getUsersByWrapper(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer age) {
        
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        
        if (username != null && !username.isEmpty()) {
            wrapper.like("username", username);
        }
        if (age != null) {
            wrapper.ge("age", age);
        }
        wrapper.orderByDesc("id");
        
        List<User> users = userService.list(wrapper);
        return Result.success(users);
    }

    @Operation(summary = "事务测试-保存", description = "测试事务保存功能")
    @PostMapping("/transaction/save")
    public Result<Boolean> saveWithTransaction(@RequestBody User user){
        boolean result = userService.saveWithTransaction(user);
        return Result.success(result);
    }

    @Operation(summary = "事务测试-转账演示", description = "演示事务回滚（会故意出错）")
    @PostMapping("/transaction/transfer")
    public Result<String> transferDemo(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam int amount) {
        try {
            userService.transferDemo(fromId, toId, amount);
            return Result.success("转账成功");
        } catch (Exception e) {
            return Result.error("转账失败，已回滚: " + e.getMessage());
        }
    }
}
