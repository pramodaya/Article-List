package com.listarticle.article.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT date_published AS publishingDate, COUNT(*) AS count FROM article "
            + "WHERE date_published BETWEEN :startDate AND :endDate "
            + "GROUP BY date_published", nativeQuery = true)
    List<ArticleCount> countByPublishingDateBetween(
            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
