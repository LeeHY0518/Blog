package com.HongYong.blog.service;

import com.HongYong.blog.vo.CategoryVo;

import java.util.List;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);
}
