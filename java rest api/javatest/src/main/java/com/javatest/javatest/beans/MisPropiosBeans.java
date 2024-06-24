package com.javatest.javatest.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MisPropiosBeans {

    @Bean
    MiBean miBean(){
        return new MiBean();
    }
}



