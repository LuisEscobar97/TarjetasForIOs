package com.ios.tarjetas.services;

import org.springframework.stereotype.Service;

import com.ios.tarjetas.entities.Componente;
import com.ios.tarjetas.entities.Tarjeta;
import com.ios.tarjetas.respositories.TarjetaRespository;
@Service
public class TarjetaDAOImpl extends GenericDAOImpl<Tarjeta, TarjetaRespository> implements TarjetaDAO{

	public TarjetaDAOImpl(TarjetaRespository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tarjeta asociarComponenteTarjeta(Componente componente, Tarjeta tarjeta) {
		tarjeta.setComponente(componente);
		return repository.save(tarjeta);
	}

}
