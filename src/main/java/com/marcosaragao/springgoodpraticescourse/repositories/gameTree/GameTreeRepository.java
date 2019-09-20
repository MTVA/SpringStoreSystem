package com.marcosaragao.springgoodpraticescourse.repositories.gameTree;

import com.marcosaragao.springgoodpraticescourse.domain.gameTree.GameTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTreeRepository extends JpaRepository<GameTree, Integer> {
}
