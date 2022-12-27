package com.listarticle.article.Article;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;

@Entity
@Table
public class Article {
    @Id
    @SequenceGenerator(
            name = "article_sequence",
            sequenceName = "article_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_sequence"
    )
    private Long id;
    @Column(length = 10)
    private String title;
    private String author;

    private String content;
    private LocalDate datePublished;

    public Article() {
    }

    public Article(Long id, String title, String author, String content, LocalDate datePublished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.datePublished = datePublished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(String title, String author, String content, LocalDate datePublished) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.datePublished = datePublished;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", datePublished=" + datePublished +
                '}';
    }
}
