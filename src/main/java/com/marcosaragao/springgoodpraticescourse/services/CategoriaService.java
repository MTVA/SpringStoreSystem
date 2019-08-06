package com.marcosaragao.springgoodpraticescourse.services;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.services.exceptions.ObjectNotFoundException;
import com.marcosaragao.springgoodpraticescourse.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado. Id:" + id.toString()));
    }
}
