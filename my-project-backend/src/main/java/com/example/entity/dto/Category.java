package com.example.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("category")
@AllArgsConstructor
public class Category implements BaseData {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String categoryName;
    private String categoryAlias;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Category(Integer id, String categoryName, String categoryAlias, LocalDateTime updateTime) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryAlias = categoryAlias;
        this.updateTime = updateTime;
    }
}
