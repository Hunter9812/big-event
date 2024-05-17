package com.example.service;

import com.example.entity.dto.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.vo.request.CategoryAddVO;

/**
* @author Hunter
* @description 针对表【category】的数据库操作Service
* @createDate 2024-01-09 14:28:31
*/
public interface CategoryService extends IService<Category> {

    String addCategory(CategoryAddVO vo, Integer id);

    String deleteById(Integer id);
}
