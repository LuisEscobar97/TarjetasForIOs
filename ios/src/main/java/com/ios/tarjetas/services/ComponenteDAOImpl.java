package com.ios.tarjetas.services;

import org.springframework.stereotype.Service;

import com.ios.tarjetas.entities.Componente;
import com.ios.tarjetas.respositories.ComponenteRepository;
@Service
public class ComponenteDAOImpl extends GenericDAOImpl<Componente, ComponenteRepository> implements ComponenteDAO{

	public ComponenteDAOImpl(ComponenteRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
