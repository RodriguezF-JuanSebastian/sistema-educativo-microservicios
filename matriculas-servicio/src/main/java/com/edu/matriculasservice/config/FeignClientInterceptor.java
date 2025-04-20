package com.edu.matriculasservice.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientInterceptor implements RequestInterceptor {

    @Value("${microservicios.token-jwt}")
    private String tokenJwt;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + tokenJwt);
    }
}
