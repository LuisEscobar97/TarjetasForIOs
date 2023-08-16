package com.ios.tarjetas.services;

import org.springframework.stereotype.Service;

import com.ios.tarjetas.entities.Linea;
import com.ios.tarjetas.entities.Maquina;
import com.ios.tarjetas.respositories.MaquinaRepository;
@Service
public class MaquinaDAOImpl extends GenericDAOImpl<Maquina, MaquinaRepository> implements MaquinaDAO{

	public MaquinaDAOImpl(MaquinaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Maquina asociarMaquinaLinea(Maquina maquina, Linea linea) {
		Maquina maquinaAux= maquina;
		maquinaAux.setLinea(linea);
		return repository.save(maquinaAux);
	}

}
