package com.sbs.jhs.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.jhs.be.dto.Article;
import com.sbs.jhs.be.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		List<Article> articles = articleService.getArticles();
		return articles;
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Article getArticle(int id) {
		Article article = articleService.getArticle(id);
		return article;
	}
}
