package com.marcosaragao.springgoodpraticescourse.resource;

import com.marcosaragao.springgoodpraticescourse.domain.Categoria;
import com.marcosaragao.springgoodpraticescourse.dto.CategoriaDTO;
import com.marcosaragao.springgoodpraticescourse.services.CategoriaService;
import com.marcosaragao.springgoodpraticescourse.util.URIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = URIs.CATEGORIAS)
public class CategoriaResource {

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        Categoria obj = categoriaService.find(id);

        //Dividir array em duas partes
        int[] array = new int[6];
        int[] arrayLeft = new int[array.length];
        int[] arrayRight = new int[array.length];
        for(int i=0;i<array.length;i++){
            if(i<array.length/2){
                arrayLeft[i] = array[i];
            }
            else{
                arrayRight[i - array.length/2] = array[i];
            }
        }

        //Ver elementos de um array
        System.out.print("Lista - ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        //Ver Matriz
        int[][] matriz = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }



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

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO) {
        Categoria obj = categoriaService.fromDTO(objDTO);
        obj = categoriaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/populate")
    public ResponseEntity<Void> populateDatabase(){
        categoriaService.populateDataBase();
        return ResponseEntity.ok().body(null);
    }
}
