package com.marcosaragao.springgoodpraticescourse.services;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.domain.Produto;
import com.marcosaragao.springgoodpraticescourse.repositories.CategoriaRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
>>>>>>> 1b8cea046e6aa5376ff734f3755b3b302754703e

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public void intentiateTestDataBase(){
        Categoria cat1 = new Categoria(null, "Açao");
        Categoria cat2 = new Categoria(null, "RPG");
        Categoria cat3 = new Categoria(null, "Luta");
        Categoria cat4 = new Categoria(null, "Futebol");
        Categoria cat5 = new Categoria(null, "Mobile");
        Categoria cat6 = new Categoria(null, "Demo");

        /*Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));*/

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
        //produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
