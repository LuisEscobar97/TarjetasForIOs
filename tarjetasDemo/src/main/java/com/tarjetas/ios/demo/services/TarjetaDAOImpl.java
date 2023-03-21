package com.tarjetas.ios.demo.services;

import org.springframework.stereotype.Service;

import com.tarjetas.ios.demo.entities.Tarjeta;
import com.tarjetas.ios.demo.respositories.TarjetaRespository;
@Service
public class TarjetaDAOImpl extends GenericDAOImpl<Tarjeta, TarjetaRespository> implements TarjetaDAO{

	public TarjetaDAOImpl(TarjetaRespository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
