package com.ios.tarjetas.services;

import org.springframework.stereotype.Service;

import com.ios.tarjetas.entities.Colaborador;
import com.ios.tarjetas.respositories.ColaboradorRepository;
@Service
public class ColaboradorDAOImpl extends GenericDAOImpl<Colaborador, ColaboradorRepository> implements ColaboradorDAO{

	public ColaboradorDAOImpl(ColaboradorRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
