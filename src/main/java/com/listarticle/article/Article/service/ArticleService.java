package com.listarticle.article.Article.service;


import com.listarticle.article.Article.domain.ArticleRepository;
import com.listarticle.article.Article.model.Article;
import com.listarticle.article.Article.model.ArticleCount;
import com.listarticle.article.Article.model.Page;
import com.listarticle.article.RestClientConfig.Status.StatusCodeMessage;
import com.listarticle.article.RestClientConfig.Status.StatusCodes;
import com.listarticle.article.RestClientConfig.Response.ErrorResponse;
import com.listarticle.article.RestClientConfig.Response.Response;
import com.listarticle.article.RestClientConfig.Response.SuccessResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

    @PersistenceContext
    private EntityManager entityManager;

    public Response getArticle(Page pageObj) {
        int page= pageObj.getPageNumber();
        int size= pageObj.getSize();

        if (page < 0 || size < 0) {
            return new ErrorResponse(
                    StatusCodes.BAD_REQUEST,
                    "Page and size parameters must be non-negative."
            );
        }

        try {
            int offset = page * size;
            long totalElements = articleRepository.count();
            if (offset >= totalElements) {
                return new ErrorResponse(
                        StatusCodes.BAD_REQUEST,
                        "Page number is too high."
                );
            }

            // Create a TypedQuery object from the EntityManager
            TypedQuery<Article> query = entityManager.createQuery(
                    "SELECT a FROM Article a", Article.class
            );

            // Set the values for the firstResult and maxResults parameters
            query.setFirstResult(offset);
            query.setMaxResults(size);

            // Execute the query and get the paginated results as a list
            List<Article> result = query.getResultList();

            return new SuccessResponse<>(
                    result,
                    StatusCodes.SUCCESS,
                    StatusCodeMessage.SUCCESS.getStatusCodeMessage()
            );

        } catch (Exception e) {
            return new ErrorResponse(
                    StatusCodes.INTERNAL_SERVER_ERROR,
                    e.getMessage().toString()
            );
        }
    }

    public Response addNewArticle(Article article){
        try {
            articleRepository.save(article);
            return new SuccessResponse<>(
                    article,
                    StatusCodes.CREATED,
                    StatusCodeMessage.CREATED.getStatusCodeMessage()
            );

        }catch (Exception e){
            return new ErrorResponse(
                    StatusCodes.INTERNAL_SERVER_ERROR,
                    e.getMessage().toString()
            );
        }

    }

    public Response getArticleCount(){
        try{
            LocalDate today = LocalDate.now();
            LocalDate oneWeekAgo = today.minusWeeks(1);

            Map<LocalDate, Long> statData =  articleRepository.countByPublishingDateBetween(oneWeekAgo, today)
                    .stream()
                    .collect(Collectors.toMap(ArticleCount::getPublishingDate, ArticleCount::getCount));

            return new SuccessResponse<>(
                    statData,
                    StatusCodes.SUCCESS,
                    StatusCodeMessage.SUCCESS.getStatusCodeMessage()
            );

        }catch (Exception e){
            return new ErrorResponse(
                    StatusCodes.INTERNAL_SERVER_ERROR,
                    e.getMessage().toString()
            );
        }

    }
}
