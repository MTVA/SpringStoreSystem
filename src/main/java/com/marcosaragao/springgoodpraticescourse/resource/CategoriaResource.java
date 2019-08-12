package com.marcosaragao.springgoodpraticescourse.resource;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.dto.CategoriaDTO;
import com.marcosaragao.springgoodpraticescourse.services.CategoriaService;
import com.marcosaragao.springgoodpraticescourse.util.URIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URIs.CATEGORIAS)
public class CategoriaResource {

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        Categoria obj = categoriaService.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/page", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id")String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction){

        Page<Categoria> list = categoriaService.findPage(page, linesPerPage, orderBy, direction);
        Page<CategoriaDTO> categoriaDTO = list.map(obj -> new CategoriaDTO(obj));

        return ResponseEntity.ok().body(categoriaDTO);
    }

}
