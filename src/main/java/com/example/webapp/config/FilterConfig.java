package com.example.webapp.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.webapp.Filter.ApiAuthFilter;
import com.example.webapp.service.ApiAuthService;

@Configuration
public class FilterConfig {
	
    private final ApiAuthService apiAuthService;
	
	public FilterConfig(ApiAuthService apiAuthService) {
        this.apiAuthService = apiAuthService;
    }

    @Bean
    public FilterRegistrationBean<ApiAuthFilter> apiAuthFilterRegistration() {
        FilterRegistrationBean<ApiAuthFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new ApiAuthFilter(apiAuthService));
        registration.addUrlPatterns("/todos/edit/*"); // 特定のパスにフィルタを適用
        return registration;
    }
}