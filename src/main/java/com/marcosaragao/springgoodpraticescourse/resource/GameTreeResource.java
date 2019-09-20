package com.marcosaragao.springgoodpraticescourse.resource;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTree;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeWinnerEnum;
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

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

        GameTree obj = gameTreeService.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{winner}", method = RequestMethod.POST)
    public ResponseEntity<?> playStep(@PathVariable GameTreeWinnerEnum winner){

        GameTree obj = gameTreeService.playStep(winner);

        return ResponseEntity.ok().body(obj);
    }

}
