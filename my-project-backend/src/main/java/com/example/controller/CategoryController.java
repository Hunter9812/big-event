package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.dto.Category;
import com.example.entity.vo.request.CategoryAddVO;
import com.example.entity.vo.request.CategoryPutVO;
import com.example.entity.vo.response.CategoryInfoVO;
import com.example.service.CategoryService;
import com.example.utils.Const;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Delete;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Validated
@RestController
@RequestMapping("/api/category")
@Tag(name = "文章分类", description = "对文章分类的信息进行处理。")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @PostMapping("")
    public RestBean<Void> add(@RequestBody @Valid CategoryAddVO vo, HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        return this.messageHandle(() ->
                categoryService.addCategory(vo, id));
    }

    @GetMapping("")
    public RestBean<List<CategoryInfoVO>> add(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute(Const.ATTR_USER_ID);
        List<CategoryInfoVO> info = categoryService.listByMap(Map.of("create_user", id)).stream()
                .map(category -> category.asViewObject(CategoryInfoVO.class)).toList();
        return RestBean.success(info);
    }

    @PutMapping("")
    public RestBean<Void> update(@RequestBody @Valid CategoryPutVO vo) {
        boolean b = categoryService.updateById(new Category(vo.getId(), vo.getCategoryName(), vo.getCategoryAlias(), LocalDateTime.now()));
        return this.messageHandle(() ->
                b ? null : "更新失败，请联系管理员");
    }

    @GetMapping("/detail")
    public RestBean<CategoryInfoVO> detail(@RequestParam Integer id) {
        Category byId = categoryService.getById(id);
        if (byId == null) return RestBean.failure(400, "查询失败，请联系管理员");
        return RestBean.success(byId.asViewObject(CategoryInfoVO.class));
    }

    @DeleteMapping("")
    public RestBean<Void> deleteById(@RequestParam Integer id) {
        return this.messageHandle(() ->
                categoryService.deleteById(id));
    }

    private <T> RestBean<T> messageHandle(Supplier<String> action) {
        String message = action.get();
        return message == null ? RestBean.success() : RestBean.failure(400, message);
    }
}
