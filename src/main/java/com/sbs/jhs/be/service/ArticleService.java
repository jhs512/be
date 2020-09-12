package com.sbs.jhs.be.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.jhs.be.dao.ArticleDao;
import com.sbs.jhs.be.dto.Article;
import com.sbs.jhs.be.util.CUtil;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;

	public List<Article> getArticles(Map<String, Object> param) {
		return articleDao.getArticles(param);
	}

	public Article getArticle(int id) {
		return articleDao.getArticle(id);
	}

	public int addArticle(Map<String, Object> param) {
		articleDao.addArticle(param);
		int id = CUtil.getAsInt(param.get("id"));
		return id;
	}

	public void modifyArticle(Map<String, Object> param) {
		articleDao.modifyArticle(param);
	}

	public void deleteArticle(int id) {
		articleDao.deleteArticle(id);
	}

}
