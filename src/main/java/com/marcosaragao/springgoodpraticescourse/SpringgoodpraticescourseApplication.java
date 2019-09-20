package com.marcosaragao.springgoodpraticescourse;

import com.marcosaragao.springgoodpraticescourse.domain.old.Categoria;
import com.marcosaragao.springgoodpraticescourse.domain.old.Cidade;
import com.marcosaragao.springgoodpraticescourse.domain.old.Estado;
import com.marcosaragao.springgoodpraticescourse.domain.old.Produto;
import com.marcosaragao.springgoodpraticescourse.repositories.CategoriaRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.CidadeRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.EstadoRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringgoodpraticescourseApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringgoodpraticescourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Açao");
        Categoria cat2 = new Categoria(null, "RPG");
        Categoria cat3 = new Categoria(null, "Luta");
        Categoria cat4 = new Categoria(null, "Futebol");
        Categoria cat5 = new Categoria(null, "Mobile");
        Categoria cat6 = new Categoria(null, "Demo");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
