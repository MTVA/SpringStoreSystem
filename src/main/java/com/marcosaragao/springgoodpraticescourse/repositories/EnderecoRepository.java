package com.marcosaragao.springgoodpraticescourse.repositories;

import com.marcosaragao.springgoodpraticescourse.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
