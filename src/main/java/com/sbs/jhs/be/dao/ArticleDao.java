package com.sbs.jhs.be.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sbs.jhs.be.dto.Article;

@Mapper
public interface ArticleDao {
	List<Article> getArticles();

	Article getArticle(@Param("id") int id);
}
