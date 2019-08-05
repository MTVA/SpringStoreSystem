package com.marcosaragao.springgoodpraticescourse.resource;

import com.marcosaragao.springgoodpraticescourse.util.URIs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= URIs.CATEGORIAS)
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public String listar(){
        return "Funcionando";
    }
}
