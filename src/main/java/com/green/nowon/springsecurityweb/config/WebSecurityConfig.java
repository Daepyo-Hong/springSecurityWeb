package com.green.nowon.springsecurityweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize ->
                        authorize
                                .antMatchers("/").permitAll()
                                .anyRequest().authenticated()   //모든 요청에 대해서 인증이 필요해요
                )
                .formLogin();

        return http.build();
    }
}
