package com.tarjetas.ios.demo.respositories;

import org.springframework.data.repository.CrudRepository;

import com.tarjetas.ios.demo.entities.Tarjeta;

public interface TarjetaRespository extends CrudRepository<Tarjeta, Integer> {

}
