package com.listarticle.article.Article.service;


import com.listarticle.article.Article.domain.ArticleRepository;
import com.listarticle.article.Article.model.Article;
import com.listarticle.article.Article.model.ArticleCount;
import com.listarticle.article.RestClientConfig.Status.StatusCodeMessage;
import com.listarticle.article.RestClientConfig.Status.StatusCodes;
import com.listarticle.article.RestClientConfig.Response.ErrorResponse;
import com.listarticle.article.RestClientConfig.Response.Response;
import com.listarticle.article.RestClientConfig.Response.SuccessResponse;
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

    public Response getArticle(){
        try {
            List<Article> result =  articleRepository.findAll();
            return new SuccessResponse<>(
                    result,
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
