package com.example.entity.vo.request;

import com.example.anno.State;
import lombok.Data;

@Data
public class ArticlePutUpdateVO {
    private Integer id;
    private String title;
    private String content;
    private String coverImg;
    @State
    private String state;
    private Integer categoryId;
}
