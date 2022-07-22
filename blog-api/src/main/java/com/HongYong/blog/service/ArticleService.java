package com.HongYong.blog.service;

import com.HongYong.blog.vo.Result;
import com.HongYong.blog.vo.params.PageParams;

public interface ArticleService {

    /*分页查询 文章列表*/
    Result listArticle(PageParams pageParams);

    /*最热文章*/
    Result hotArticle(int limit);

    /*最新文章*/
    Result newArticles(int limit);

    /*文章归类*/
    Result listArchives();

    /*查看文章详情*/
    Result findArticleById(Long articleId);
}
