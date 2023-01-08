package com.listarticle.article.Article.controller;

import com.listarticle.article.Article.model.Page;
import com.listarticle.article.RestClientConfig.Response.Response;
import com.listarticle.article.Article.service.ArticleService;
import com.listarticle.article.Article.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Method GET
     * This will return all articles
     * @return Response
     */
    @GetMapping
    public Response getArticle(@RequestBody Page page)
    {
        return articleService.getArticle(page);
    }
    /**
     * Method POST
     * This will add article
     * @param article
     */
    @PostMapping("/add")
    public Response addArticle(@Validated @RequestBody Article article) {
        return articleService.addNewArticle(article);
    }
    /**
     * Method GET
     * This will return statistics
     * Only 'ADMIN' user's can access
     * @return Response
     */
    @GetMapping("/statistic")
    @PreAuthorize("hasRole('ADMIN')")
    public Response getStatistics(){
        return articleService.getArticleCount();
    }
}

