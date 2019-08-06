package com.marcosaragao.springgoodpraticescourse.repositories;

import com.marcosaragao.springgoodpraticescourse.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
