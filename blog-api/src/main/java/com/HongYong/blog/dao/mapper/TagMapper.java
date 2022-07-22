package com.HongYong.blog.dao.mapper;

import com.HongYong.blog.dao.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    /*根据文章id查询标签列表*/
    List<Tag> findTagsByArticleId(Long articleId);

    /*查询最热的标签 前N条*/
    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
