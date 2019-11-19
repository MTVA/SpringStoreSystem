package com.marcosaragao.springgoodpraticescourse;

import com.marcosaragao.springgoodpraticescourse.domain.*;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTree;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombat;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombatant;
import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeRound;
import com.marcosaragao.springgoodpraticescourse.enums.TipoCliente;
import com.marcosaragao.springgoodpraticescourse.repositories.*;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeCombatantRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRepository;
import com.marcosaragao.springgoodpraticescourse.repositories.gameTree.GameTreeRoundRepository;
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
    @Autowired
    private GameTreeRepository gameTreeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

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


        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
    }
}
