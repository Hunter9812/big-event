package com.example.entity.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.BaseData;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 数据库中的用户信息
 */
@Data
@TableName("account")
@AllArgsConstructor
@NoArgsConstructor
public class Account implements BaseData {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;
    private String userPic;//用户头像地址
    private String nickname;//昵称
    private String biography;//个人简介
}
