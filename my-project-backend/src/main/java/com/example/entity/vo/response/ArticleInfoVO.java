package com.example.entity.vo.response;

import com.example.anno.State;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleInfoVO {
    private Integer id;
    private String title;
    private String content;
    private String coverImg;
    @State
    private String state;
    private Integer categoryId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
