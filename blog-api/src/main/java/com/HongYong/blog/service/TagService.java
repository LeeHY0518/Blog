package com.HongYong.blog.service;

import com.HongYong.blog.vo.Result;
import com.HongYong.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);
}
