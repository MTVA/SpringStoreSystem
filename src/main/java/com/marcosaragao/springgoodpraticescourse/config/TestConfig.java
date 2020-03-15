package com.marcosaragao.springgoodpraticescourse.config;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.domain.Produto;
import com.marcosaragao.springgoodpraticescourse.repositories.CategoriaRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.ProdutoRepository;
import com.marcosaragao.springgoodpraticescourse.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

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
