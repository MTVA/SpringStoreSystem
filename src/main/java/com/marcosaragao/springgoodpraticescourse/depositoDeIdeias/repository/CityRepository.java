package com.marcosaragao.springgoodpraticescourse.depositoDeIdeias.repository;

import br.com.enovar.telli.model.location.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
