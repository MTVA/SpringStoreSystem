package com.marcosaragao.springgoodpraticescourse.repositories.old;

import com.marcosaragao.springgoodpraticescourse.domain.old.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
