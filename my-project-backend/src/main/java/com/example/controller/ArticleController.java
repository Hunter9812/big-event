package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.dto.Article;
import com.example.entity.vo.request.ArticleAddVO;
import com.example.entity.vo.request.ArticlePutUpdateVO;
import com.example.entity.vo.response.ArticleInfoVO;
import com.example.entity.vo.response.ArticlePageVO;
import com.example.service.ArticleService;
import com.example.utils.Const;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@Validated
@RestController
@RequestMapping("/api/article")
@Tag(name = "文章管理", description = "包括文章的增删改查的操作。")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping
    public RestBean<Void> add(@RequestBody @Valid ArticleAddVO vo, HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        return this.messageHandle(() ->
                articleService.add(vo, id));
    }

    @GetMapping
    public RestBean<ArticlePageVO> list(
            @NotNull Integer pageNum,
            @NotNull Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state,
            HttpServletRequest request
    ) {
        Integer id = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        ArticlePageVO info = articleService.listAll(pageNum, pageSize, categoryId, state, id);
        if (info == null) return RestBean.failure(400, "查询失败，请联系管理员");
        return RestBean.success(info);
    }

    @PutMapping
    public RestBean<Void> update(@RequestBody @Valid ArticlePutUpdateVO vo) {
        return this.messageHandle(() ->
                articleService.updateInfo(vo));
    }

    @DeleteMapping
    public RestBean<Void> delete(Integer id, HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        return this.messageHandle(() ->
                articleService.deleteById(id, userId));
    }


    @GetMapping("/detail")
    public RestBean<ArticleInfoVO> detail(Integer id) {
        Article info = articleService.getById(id);
        if (info == null) return RestBean.failure(400, "查询失败，请联系管理员");
        return RestBean.success(info.asViewObject(ArticleInfoVO.class));
    }

    private <T> RestBean<T> messageHandle(Supplier<String> action) {
        String message = action.get();
        return message == null ? RestBean.success() : RestBean.failure(400, message);
    }
}
