package com.marcosaragao.springgoodpraticescourse.repositories.old;

import com.marcosaragao.springgoodpraticescourse.domain.old.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
