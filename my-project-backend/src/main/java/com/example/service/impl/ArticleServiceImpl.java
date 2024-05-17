package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.dto.Article;
import com.example.entity.vo.request.ArticleAddVO;
import com.example.entity.vo.request.ArticlePutUpdateVO;
import com.example.entity.vo.response.ArticleInfoVO;
import com.example.entity.vo.response.ArticlePageVO;
import com.example.service.ArticleService;
import com.example.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Hunter
 * @description 针对表【article】的数据库操作Service实现
 * @createDate 2024-01-09 17:23:31
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
        implements ArticleService {

    @Override
    public String add(ArticleAddVO vo, Integer id) {
        Article article = new Article(vo.getTitle(), vo.getContent(), vo.getCoverImg(), vo.getState(), vo.getCategoryId(), id, LocalDateTime.now(), LocalDateTime.now());
        boolean save = this.save(article);
        return save ? null : "添加失败，请联系管理员";
    }

    @Override
    public ArticlePageVO listAll(Integer pageNum, Integer pageSize, Integer categoryId, String state, Integer id) {
        LambdaQueryChainWrapper<Article> lambdaQuery = this.lambdaQuery();
        if (categoryId != null)
            lambdaQuery.eq(Article::getCategoryId, categoryId);
        if (state != null)
            lambdaQuery.eq(Article::getState, state);
        Page<Article> page = lambdaQuery.eq(Article::getCreateUser, id)
                .page(new Page<>(pageNum, pageSize));

        List<ArticleInfoVO> list = page.getRecords().stream().map(article ->
                article.asViewObject(ArticleInfoVO.class)).toList();

        return new ArticlePageVO((int) page.getTotal(), list);
    }

    @Override
    public String updateInfo(ArticlePutUpdateVO vo) {
        boolean update = this.lambdaUpdate().eq(Article::getId, vo.getId())
                .set(Article::getTitle, vo.getTitle())
                .set(Article::getContent, vo.getContent())
                .set(Article::getCoverImg, vo.getCoverImg())
                .set(Article::getState, vo.getState())
                .set(Article::getCategoryId, vo.getCategoryId())
                .set(Article::getUpdateTime, LocalDateTime.now()).update();
        return update ? null : "更新失败，请联系管理员";
    }

    @Override
    public String deleteById(Integer id, Integer userId) {
        LambdaQueryWrapper<Article> eq = new LambdaQueryWrapper<Article>()
                .eq(Article::getId, id)
                .eq(Article::getCreateUser, userId);

        boolean remove = this.remove(eq);
        return remove ? null : "删除失败，请联系管理员";
    }
}




