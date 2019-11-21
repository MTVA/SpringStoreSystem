package com.marcosaragao.springgoodpraticescourse.repositories.gameTree;

import com.marcosaragao.springgoodpraticescourse.domain.general.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
