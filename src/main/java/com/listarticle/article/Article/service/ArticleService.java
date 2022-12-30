package com.listarticle.article.Article.service;


import com.listarticle.article.Article.domain.ArticleRepository;
import com.listarticle.article.Article.model.Article;
import com.listarticle.article.Article.model.ArticleCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticle(){
        return articleRepository.findAll();
    }

    public void addNewArticle(Article article){
        System.out.println(article);
        articleRepository.save(article);
    }

    public Map<LocalDate, Long> getArticleCount(){
        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusWeeks(1);

        List<ArticleCount>  x = articleRepository.countByPublishingDateBetween(oneWeekAgo, today);
        System.out.println(x.stream().count());
        return articleRepository.countByPublishingDateBetween(oneWeekAgo, today)
                .stream()
                .collect(Collectors.toMap(ArticleCount::getPublishingDate, ArticleCount::getCount));
    }
}
