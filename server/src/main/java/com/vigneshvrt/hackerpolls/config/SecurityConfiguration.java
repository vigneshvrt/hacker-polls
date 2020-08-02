package com.vigneshvrt.hackerpolls.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String[] STATIC_FILES = {
            "/.*\\.js","/.*\\.css","/.*\\.txt","/.*\\.html",
            "/.*\\.ico","/.*\\.gif","/.*\\.jpg","/.*\\.swf",
            "/.*\\.png","/.*\\.woff2"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .regexMatchers(HttpMethod.GET, STATIC_FILES).permitAll()
                .antMatchers(HttpMethod.POST, "/api/vote/add").permitAll()
                .antMatchers(HttpMethod.GET, "/", "/api/candidate").permitAll()
                .regexMatchers(HttpMethod.GET, "\\/api\\/candidate\\/\\d+").permitAll()
                .anyRequest().authenticated()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
