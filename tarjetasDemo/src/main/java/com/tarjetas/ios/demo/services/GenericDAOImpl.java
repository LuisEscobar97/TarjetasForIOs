package com.tarjetas.ios.demo.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tarjetas.ios.demo.exceptions.NotFoundException;

public class GenericDAOImpl <E,R extends CrudRepository<E, Integer>> implements GenericoDAO<E>{
	
	protected  final R repository;
	
	public GenericDAOImpl(R repository) {
		this.repository= repository;
	}
	
	@Override
	public Optional<E> buscarPorID(Integer id) {
		Optional<E> objetoEncontrado= repository.findById(id);
		if(!objetoEncontrado.isPresent())
			throw new NotFoundException(String.format("El regsitro buscado con ID: %d no existe", id));
		return objetoEncontrado;
	}

	@Override
	public E guardar(E entidad) {
		
		return repository.save(entidad);
	}

	@Override
	public Iterable<E> buscarTodos() {
		
		return repository.findAll();
	}

	@Override
	public void eliminarPorId(Integer id) {
		repository.deleteById(id);
		
	}
	
	

}
