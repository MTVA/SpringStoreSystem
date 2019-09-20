package com.marcosaragao.springgoodpraticescourse.repositories.gameTree;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTreeCombatRepository extends JpaRepository<GameTreeCombat, Integer> {
}
