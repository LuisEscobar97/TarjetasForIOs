package com.tarjetas.ios.demo.services;

import org.springframework.stereotype.Service;

import com.tarjetas.ios.demo.entities.Area;
import com.tarjetas.ios.demo.respositories.AreaRepository;

@Service
public class AreaDAOImpl extends GenericDAOImpl<Area, AreaRepository> implements AreaDAO{

	public AreaDAOImpl(AreaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	

}
