package com.kaif.springadminpanel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppCofig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
