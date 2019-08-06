package com.marcosaragao.springgoodpraticescourse;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringgoodpraticescourseApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringgoodpraticescourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Games");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

    }
}
