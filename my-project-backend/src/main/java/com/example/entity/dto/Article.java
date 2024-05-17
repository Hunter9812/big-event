package com.example.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.anno.State;
import com.example.entity.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@TableName("article")
@NoArgsConstructor
@AllArgsConstructor
public class Article implements BaseData {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private String coverImg;
    @State
    private String state;
    private Integer categoryId;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Article(String title, String content, String coverImg, String state, Integer categoryId, Integer createUser, LocalDateTime createTime, LocalDateTime updateTime) {
        this.title = title;
        this.content = content;
        this.coverImg = coverImg;
        this.state = state;
        this.categoryId = categoryId;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
