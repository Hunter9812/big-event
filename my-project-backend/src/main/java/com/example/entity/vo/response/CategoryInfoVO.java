package com.example.entity.vo.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryInfoVO {
    private Integer id;
    private String categoryName;
    private String categoryAlias;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
