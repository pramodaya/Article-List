package com.listarticle.article.Config.Security;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.security.user.name}")
    private String user;
    @Value("${spring.security.user.password}")
    private String userPassword;
    @Value("${spring.security.user.role}")
    private String userRole;
    @Value("${spring.security.user.authorities}")
    private String[] userAuthorities;

    @Value("${spring.security.admin.name}")
    private String admin;
    @Value("${spring.security.admin.password}")
    private String adminPassword;
    @Value("${spring.security.admin.role}")
    private String adminRole;
    @Value("${spring.security.admin.authorities}")
    private String[] adminAuthorities;

    @Value("${application.route.articleRoute}")
    private String articleRoute;
    @Value("${application.route.statisticRoute}")
    private String statisticRoute;

    @Bean
    public InMemoryUserDetailsManager users(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(user)
                .password(userPassword)
                .authorities(userAuthorities)
                .roles(userRole)
                .build());
        manager.createUser(User.withUsername(admin)
                .password(adminPassword)
                .authorities(adminAuthorities)
                .roles(adminRole)
                .build());

       return manager;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers(articleRoute).permitAll()
                .requestMatchers(statisticRoute).hasRole(adminRole)
                .anyRequest()
                .authenticated();
        httpSecurity.formLogin();
        httpSecurity.httpBasic();
        return httpSecurity.build();
    }
}
