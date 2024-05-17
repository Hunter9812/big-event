package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.dto.Category;
import com.example.entity.vo.request.CategoryAddVO;
import com.example.service.CategoryService;
import com.example.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Hunter
 * @description 针对表【category】的数据库操作Service实现
 * @createDate 2024-01-09 14:28:31
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {

    @Override
    public String addCategory(CategoryAddVO vo, Integer id) {
        Category category = new Category(null, vo.getCategoryName(), vo.getCategoryAlias(), id, LocalDateTime.now(), LocalDateTime.now());
        boolean save = this.save(category);
        return save ? null : "添加失败，请联系管理员";
    }

    @Override
    public String deleteById(Integer id) {
        boolean b = this.removeById(id);
        return b ? null : "删除失败，请联系管理员";
    }
}




