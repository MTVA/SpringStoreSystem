package com.marcosaragao.springgoodpraticescourse.resource;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.util.URIs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= URIs.CATEGORIAS)
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar(){

        Categoria cat1 = new Categoria(1, "Informatica");
        Categoria cat2 = new Categoria(2, "Escritorio");

        List<Categoria> lista = new ArrayList<>();

        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }

}
