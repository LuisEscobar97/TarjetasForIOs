package com.tarjetas.ios.demo.services;

import org.springframework.stereotype.Service;

import com.tarjetas.ios.demo.entities.Maquina;
import com.tarjetas.ios.demo.respositories.MaquinaRepository;
@Service
public class MaquinaDAOImpl extends GenericDAOImpl<Maquina, MaquinaRepository> implements MaquinaDAO{

	public MaquinaDAOImpl(MaquinaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
