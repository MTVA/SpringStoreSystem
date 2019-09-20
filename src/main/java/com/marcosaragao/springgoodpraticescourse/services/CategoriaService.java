package com.marcosaragao.springgoodpraticescourse.services;

import com.marcosaragao.springgoodpraticescourse.domain.old.Categoria;
import com.marcosaragao.springgoodpraticescourse.domain.old.Produto;
import com.marcosaragao.springgoodpraticescourse.dto.CategoriaDTO;
import com.marcosaragao.springgoodpraticescourse.repositories.ProdutoRepository;
import com.marcosaragao.springgoodpraticescourse.services.exceptions.ObjectNotFoundException;
import com.marcosaragao.springgoodpraticescourse.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado. Id:" + id.toString()));
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria insert(Categoria obj){
        return categoriaRepository.save(obj);
    }

    public Categoria fromDTO(CategoriaDTO objDTO){
        return new Categoria(objDTO.getId(), objDTO.getNome());
    }

    public void populateDataBase(){

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
    }
}
