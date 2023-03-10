package com.tarjetas.ios.demo.services;

import com.tarjetas.ios.demo.entities.Linea;
import com.tarjetas.ios.demo.respositories.LineaRepository;

public class LineaDAOImpl extends GenericDAOImpl<Linea, LineaRepository> implements LineaDAO {

	public LineaDAOImpl(LineaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	

}
