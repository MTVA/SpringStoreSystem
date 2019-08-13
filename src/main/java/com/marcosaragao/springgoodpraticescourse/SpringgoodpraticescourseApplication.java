package com.marcosaragao.springgoodpraticescourse;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.domain.Produto;
import com.marcosaragao.springgoodpraticescourse.repositories.CategoriaRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringgoodpraticescourseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringgoodpraticescourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
