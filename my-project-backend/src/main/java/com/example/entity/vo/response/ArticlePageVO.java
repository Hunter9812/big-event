package com.example.entity.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ArticlePageVO {
    private Integer total;
    private List<ArticleInfoVO> items;
}
