package com.marcosaragao.springgoodpraticescourse.repositories.gameTree;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTreeRoundRepository extends JpaRepository<GameTreeRound, Integer> {
}
