package com.sbs.jhs.be.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.jhs.be.dto.Article;

@Mapper
public interface ArticleDao {
	List<Article> getArticles();
}
