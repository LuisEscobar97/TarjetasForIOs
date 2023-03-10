package com.tarjetas.ios.demo.services;

import com.tarjetas.ios.demo.entities.Colaborador;
import com.tarjetas.ios.demo.respositories.ColaboradorRepository;

public class ColaboradorDAOImpl extends GenericDAOImpl<Colaborador, ColaboradorRepository> implements ColaboradorDAO{

	public ColaboradorDAOImpl(ColaboradorRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
