package com.codegym.duytan.config.security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.stereotype.*;

@Component
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Thiếu config này để gọi request từ domain khác
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**").permitAll();

    }
}
