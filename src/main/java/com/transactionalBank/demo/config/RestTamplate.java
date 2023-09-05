package com.transactionalBank.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTamplate {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
