package com.listarticle.article.Config.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager users(){

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("pramodaya")
                .password("{noop}password")
                .authorities("read", "write")
                .roles("USER")
                .build());

        manager.createUser(User.withUsername("john")
                .password("{noop}password")
                .authorities("read", "write", "delete")
                .roles("ADMIN")
                .build());

       return manager;
    }


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
