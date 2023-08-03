package com.ios.tarjetas.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ios.tarjetas.entities.Colaborador;
import com.ios.tarjetas.exceptions.BadRequestException;
import com.ios.tarjetas.services.ColaboradorDAO;
import com.ios.tarjetas.utils.TarjetasUtils;

@RestController
@RequestMapping("/colab")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorDAO colaboradorDAO;
	
	@GetMapping("/get")
	public ResponseEntity<?>getColaborador(@RequestParam(name="id")Integer id){
		Optional<Colaborador>colaborador= colaboradorDAO.buscarPorID(id);
		
		if(!colaborador.isPresent())
			throw new BadRequestException(String.format("El colabordaor con el id %d no existe", id));
		
		return new ResponseEntity<Colaborador>(colaborador.get(),HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?>addColaborador(@Valid @RequestBody Colaborador colaborador, BindingResult result){
			if(result.hasErrors())
				return TarjetasUtils.getErrors(result);
			
			Colaborador colaboradorGuardado= colaboradorDAO.guardar(colaborador);
			
			return new ResponseEntity<Colaborador>(colaborador,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAlLColabordaores(){
		List<Colaborador>colaboradores= (List<Colaborador>) colaboradorDAO.buscarTodos();
		
		if(colaboradores.isEmpty())
			throw new BadRequestException("No hay colaboradores dados de alta");
		
		return new ResponseEntity<List<Colaborador>>(colaboradores,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?>deleteColaborador(@RequestParam(name="id")Integer id){
		Optional<Colaborador>colaborador= colaboradorDAO.buscarPorID(id);
		
		if(!colaborador.isPresent())
			throw new BadRequestException(String.format("El colabordaor con el id %d no existe", id));
		
		colaboradorDAO.eliminarPorId(id);
		
		return new ResponseEntity<Colaborador>(colaborador.get(),HttpStatus.OK);
		
	}
	

}
