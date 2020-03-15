package com.marcosaragao.springgoodpraticescourse.config;

import com.marcosaragao.springgoodpraticescourse.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("dev")
public class DevConfig {

    @Autowired
    DBService dbService;

    @Bean
    public boolean instantiateDataBase(){

        dbService.intentiateTestDataBase();

        return true;
    }
}
