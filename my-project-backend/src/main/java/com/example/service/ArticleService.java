package com.example.service;

import com.example.entity.dto.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.vo.request.ArticleAddVO;
import com.example.entity.vo.request.ArticlePutUpdateVO;
import com.example.entity.vo.response.ArticlePageVO;

/**
 * @author Hunter
 * @description 针对表【article】的数据库操作Service
 * @createDate 2024-01-09 17:23:31
 */
public interface ArticleService extends IService<Article> {

    String add(ArticleAddVO vo, Integer id);

    ArticlePageVO listAll(Integer pageNum, Integer pageSize, Integer categoryId, String state, Integer id);

    String updateInfo(ArticlePutUpdateVO vo);

    String deleteById(Integer id, Integer userId);
}
