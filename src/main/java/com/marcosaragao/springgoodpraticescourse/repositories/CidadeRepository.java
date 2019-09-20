package com.marcosaragao.springgoodpraticescourse.repositories;

import com.marcosaragao.springgoodpraticescourse.domain.old.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
