package com.marcosaragao.springgoodpraticescourse;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTree;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombat;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombatant;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeRound;
import com.marcosaragao.springgoodpraticescourse.domain.old.Categoria;
import com.marcosaragao.springgoodpraticescourse.domain.old.Cidade;
import com.marcosaragao.springgoodpraticescourse.domain.old.Estado;
import com.marcosaragao.springgoodpraticescourse.domain.old.Produto;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatantRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRoundRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.old.CategoriaRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.old.CidadeRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.old.EstadoRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.old.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
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
    @Autowired
    private GameTreeRepository gameTreeRepository;

    @Autowired
    private GameTreeCombatantRepository gameTreeCombatantRepository;

    @Autowired
    private GameTreeCombatRepository gameTreeCombatRepository;

    @Autowired
    private GameTreeRoundRepository gameTreeRoundRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringgoodpraticescourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        GameTreeCombatant gameTreeCombatant1 = new GameTreeCombatant("Inception");
        GameTreeCombatant gameTreeCombatant2 = new GameTreeCombatant("Interstellar");

        GameTreeCombatant gameTreeCombatant3 = new GameTreeCombatant("Lion King");
        GameTreeCombatant gameTreeCombatant4 = new GameTreeCombatant("Aladdin");

        GameTree gameTree = new GameTree(0, null);
        GameTreeRound gameTreeRound = new GameTreeRound(0, gameTree);
        GameTreeRound gameTreeRound2 = new GameTreeRound(0, gameTree);

        GameTreeCombat gameTreeCombat = new GameTreeCombat(gameTreeCombatant1, gameTreeCombatant2, gameTreeRound);
        GameTreeCombat gameTreeCombat2 = new GameTreeCombat(gameTreeCombatant3, gameTreeCombatant4, gameTreeRound);

        gameTreeRound.setCombats(Arrays.asList(gameTreeCombat, gameTreeCombat2));

        gameTree.setRounds(Arrays.asList(gameTreeRound, gameTreeRound2));


        gameTreeCombatantRepository.saveAll(Arrays.asList(gameTreeCombatant1, gameTreeCombatant2, gameTreeCombatant3, gameTreeCombatant4));
        gameTreeRepository.save(gameTree);
        gameTreeRoundRepository.saveAll(Arrays.asList(gameTreeRound, gameTreeRound2));
        gameTreeCombatRepository.saveAll(Arrays.asList(gameTreeCombat, gameTreeCombat2));
    }
}
