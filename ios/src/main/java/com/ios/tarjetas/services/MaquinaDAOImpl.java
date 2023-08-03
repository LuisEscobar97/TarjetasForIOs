package com.ios.tarjetas.services;

import org.springframework.stereotype.Service;

import com.ios.tarjetas.entities.Maquina;
import com.ios.tarjetas.respositories.MaquinaRepository;
@Service
public class MaquinaDAOImpl extends GenericDAOImpl<Maquina, MaquinaRepository> implements MaquinaDAO{

	public MaquinaDAOImpl(MaquinaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
