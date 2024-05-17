package com.example.entity.vo.response;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoVO {
    private String username;
    private String email;
    private String role;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private String userPic;
    private String nickname;
    private String biography;
}
