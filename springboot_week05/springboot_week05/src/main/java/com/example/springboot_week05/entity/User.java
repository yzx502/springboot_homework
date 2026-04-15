package com.example.springboot_week05.entity;


import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    @Schema(description="主键")
    private Long id;
    
    @TableField("username")
    @Schema(description="用户名")
    private String username;
    
    @TableField("password")
    @Schema(description="密码")
    private String password;
    
    @TableField("age")
    @Schema(description="年龄")
    private Integer age;
    
    @TableField("email")
    @Schema(description="邮箱")
    private String email;
    
    @TableField("create_time")
    @Schema(description="创建时间")
    private LocalDateTime createTime;
}
