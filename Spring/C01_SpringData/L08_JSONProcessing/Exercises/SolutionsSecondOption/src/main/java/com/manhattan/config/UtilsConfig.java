package com.manhattan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class UtilsConfig {
    @Bean
    public BufferedReader BufferedReaderConfig(){
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
