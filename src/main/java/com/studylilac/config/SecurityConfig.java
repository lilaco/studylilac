package com.studylilac.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//EnableWebSecurity 를 하면 Spring Security 설정을 직접 하는 것.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 손쉽게 설정하기 위해 WebSecurityConfigurerAdapter 를 상속받는다.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/sign-up", "/check-email", "/check-email-token",
                        "/email-login", "/check-email-login", "/login-link").permitAll()
                //위와 같은 http 패턴으로 접속할때, Spring security 의 Auth 설정을 모두가 접근할 수 있도록 허용한다.
                .mvcMatchers(HttpMethod.GET, "/profile/*").permitAll()
                // profile 페이지는 get 방식만 모두가 접근할 수 있도록 허용.
                .anyRequest().authenticated();
                //나머지는 로그인을 해야 접속 가능.

    }
}
