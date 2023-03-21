package com.tarjetas.ios.demo.services;

import org.springframework.stereotype.Service;

import com.tarjetas.ios.demo.entities.Linea;
import com.tarjetas.ios.demo.respositories.LineaRepository;
@Service
public class LineaDAOImpl extends GenericDAOImpl<Linea, LineaRepository> implements LineaDAO {

	public LineaDAOImpl(LineaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	

}
