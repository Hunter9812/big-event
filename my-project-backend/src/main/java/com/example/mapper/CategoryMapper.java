package com.example.mapper;

import com.example.entity.dto.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Hunter
* @description 针对表【category】的数据库操作Mapper
* @createDate 2024-01-09 14:28:31
* @Entity com.example.entity.dto.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




