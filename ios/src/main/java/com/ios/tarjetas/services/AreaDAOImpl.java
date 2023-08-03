package com.ios.tarjetas.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.entities.Linea;
import com.ios.tarjetas.respositories.AreaRepository;

@Service
public class AreaDAOImpl extends GenericDAOImpl<Area, AreaRepository> implements AreaDAO{

	public AreaDAOImpl(AreaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Area asociarLineaAArea(Linea linea, Area area) {
		Set<Linea>lienas=area.getLineas();
		lienas.add(linea);
		area.setLineas(lienas);
		return repository.save(area);
	}
	

}
