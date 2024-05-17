package com.example.entity.vo.response;

import lombok.Data;

import java.util.Date;

/**
 * 登录验证成功的用户信息响应
 */
@Data
public class AuthorizeVO {
    private String username;
    private String role;
    private String token;
    private Date expire;
}
