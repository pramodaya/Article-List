package com.listarticle.article.Article.domain;

import com.listarticle.article.Article.model.Article;
import com.listarticle.article.Article.model.ArticleCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT new com.listarticle.article.Article.model.ArticleCount(a.datePublished, COUNT(a)) "
            + "FROM Article a "
            + "WHERE a.datePublished BETWEEN :startDate AND :endDate "
            + "GROUP BY a.datePublished")
    List<ArticleCount> countByPublishingDateBetween(
            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
