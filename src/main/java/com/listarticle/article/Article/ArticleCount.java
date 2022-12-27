package com.listarticle.article.Article;

import java.time.LocalDate;

public class ArticleCount {
    private LocalDate publishingDate;
    private Long count;

    public ArticleCount(LocalDate publishingDate, Long count) {
        this.publishingDate = publishingDate;
        this.count = count;
    }
    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
