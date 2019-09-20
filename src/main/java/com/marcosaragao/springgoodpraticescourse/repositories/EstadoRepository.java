package com.marcosaragao.springgoodpraticescourse.repositories;

import com.marcosaragao.springgoodpraticescourse.domain.old.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
