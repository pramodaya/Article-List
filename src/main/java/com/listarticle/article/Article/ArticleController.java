package com.listarticle.article.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
     * @return List<Article>
     */
    @GetMapping
    public List<Article> getArticle(){
        return articleService.getArticle();
    }

    /**
     * Method POST
     * This will add article
     * @param article
     */
    @PostMapping("/add")
    public void addArticle(@RequestBody Article article){
        articleService.addNewArticle(article);
    }

    /**
     * Method GET
     * This will return statistics
     * Only 'ADMIN' user's can access
     * @return Map<LocalDate, Long>
     */
    @GetMapping("/statistic")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<LocalDate, Long> getStatistics(){
        return articleService.getArticleCount();
    }
}
