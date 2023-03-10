package com.tarjetas.ios.demo.services;

import com.tarjetas.ios.demo.entities.Componente;
import com.tarjetas.ios.demo.respositories.ComponenteRepository;

public class ComponenteDAOImpl extends GenericDAOImpl<Componente, ComponenteRepository> implements ComponenteDAO{

	public ComponenteDAOImpl(ComponenteRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
