package com.marcosaragao.springgoodpraticescourse.depositoDeIdeias.repository;

import br.com.enovar.telli.model.location.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {

}
