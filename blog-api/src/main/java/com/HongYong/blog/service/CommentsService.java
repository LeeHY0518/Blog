package com.HongYong.blog.service;

import com.HongYong.blog.vo.Result;
import com.HongYong.blog.vo.params.CommentParam;

public interface CommentsService {

    //根据文章id 查询所有评论列表
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
