package com.ios.tarjetas.services;

import org.springframework.stereotype.Service;

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.entities.Linea;
import com.ios.tarjetas.respositories.LineaRepository;
@Service
public class LineaDAOImpl extends GenericDAOImpl<Linea, LineaRepository> implements LineaDAO {

	public LineaDAOImpl(LineaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Linea asociarAreaALineas(Linea linea, Area area) {
		linea.setArea(area);
		return repository.save(linea);
	}

	

}
