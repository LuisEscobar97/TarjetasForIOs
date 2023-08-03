package com.ios.tarjetas.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ios.tarjetas.entities.Linea;

public interface LineaRepository extends CrudRepository<Linea, Integer> {

}
