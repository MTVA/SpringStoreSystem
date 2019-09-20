package com.marcosaragao.springgoodpraticescourse.config;

import com.marcosaragao.springgoodpraticescourse.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    DBService dbService;

    /*@Bean
    public Boolean instantiateDataBase(){

        //dbService.intentiateTestDataBase();

        return true;
    }*/
}
