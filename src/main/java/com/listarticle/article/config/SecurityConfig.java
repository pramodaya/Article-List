package com.listarticle.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/v1/article").hasRole("USER")
                .requestMatchers("/api/v1/article/statistic").hasRole("ADMIN")
                .anyRequest()
                .authenticated();
        httpSecurity.formLogin();
        httpSecurity.httpBasic();
        return httpSecurity.build();
    }
}
