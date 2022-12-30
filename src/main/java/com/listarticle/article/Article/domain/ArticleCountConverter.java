package com.listarticle.article.Article.domain;

import com.listarticle.article.Article.model.ArticleCount;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;


@Converter
public class ArticleCountConverter implements AttributeConverter<ArticleCount, Object[]> {
    @Override
    public Object[] convertToDatabaseColumn(ArticleCount attribute) {
        throw new UnsupportedOperationException("Conversion to database column not supported");
    }
    @Override
    public ArticleCount convertToEntityAttribute(Object[] dbData) {
        LocalDate publishingDate = (LocalDate) dbData[0];
        long count = (long) dbData[1];
        return new ArticleCount(publishingDate, count);
    }
}