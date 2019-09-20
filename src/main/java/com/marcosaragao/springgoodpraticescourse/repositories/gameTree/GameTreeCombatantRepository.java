package com.marcosaragao.springgoodpraticescourse.repositories.gameTree;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTreeCombatant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTreeCombatantRepository extends JpaRepository<GameTreeCombatant, Integer> {
}
