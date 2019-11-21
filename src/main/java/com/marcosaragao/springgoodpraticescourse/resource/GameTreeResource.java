package com.marcosaragao.springgoodpraticescourse.resource;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTree;
import com.marcosaragao.springgoodpraticescourse.dto.GameTreeCreateDTO;
import com.marcosaragao.springgoodpraticescourse.dto.PlayStepDTO;
import com.marcosaragao.springgoodpraticescourse.services.GameTreeService;
import com.marcosaragao.springgoodpraticescourse.util.URIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = URIs.GAMETREE)
public class GameTreeResource {

    @Autowired
    GameTreeService gameTreeService;

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<?> createGame(@RequestBody GameTreeCreateDTO gameTreeCreateDTO){

        GameTree obj = gameTreeService.createGame(gameTreeCreateDTO);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        GameTree obj = gameTreeService.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/playstep", method = RequestMethod.POST)
    public ResponseEntity<?> playStep(@RequestBody PlayStepDTO playStepDTO){

        GameTree obj = gameTreeService.playStep(playStepDTO);

        return ResponseEntity.ok().body(obj);
    }

}
