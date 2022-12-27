package com.listarticle.article.Article;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ArticleConfig {
    @Bean
    CommandLineRunner commandLineRunner(ArticleRepository articleRepository) {
        return args -> {
                Article a1 = new Article(
                        "article 1",
                        "pramodaya",
                        "content 1",
                        LocalDate.of(2022, Month.DECEMBER,20)
                );
            Article a2 = new Article(
                    "article 2",
                    "pramodaya",
                    "content 2",
                    LocalDate.of(2022, Month.DECEMBER,15)
            );

            Article a3 = new Article(
                    "article 3",
                    "pramodaya",
                    "content 2",
                    LocalDate.of(2022, Month.DECEMBER,10)
            );
            Article a4 = new Article(
                    "article 4",
                    "pramodaya",
                    "content 2",
                    LocalDate.of(2022, Month.DECEMBER,9)
            );

            Article a5 = new Article(
                    "article 5",
                    "pramodaya",
                    "content 2",
                    LocalDate.of(2022, Month.DECEMBER,6)
            );
            articleRepository.saveAll(
                    List.of(a1, a2, a3, a4, a5)
            );
        };
    }
}
