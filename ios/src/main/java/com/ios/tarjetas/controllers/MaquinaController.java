package com.ios.tarjetas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.ios.tarjetas.entities.Maquina;
import com.ios.tarjetas.entities.Tarjeta;
import com.ios.tarjetas.exceptions.BadRequestException;
import com.ios.tarjetas.services.MaquinaDAO;
import com.ios.tarjetas.utils.TarjetasUtils;

@RequestMapping("/maquina")
@RestController
public class MaquinaController {
	
	@Autowired
	private MaquinaDAO maquinaDAO;
	
	@GetMapping("/get")
	public ResponseEntity<?> getMaquinaByID(@RequestParam(name="id")Integer id){
		
		Optional<Maquina>maquinaRecuperada= maquinaDAO.buscarPorID(id);
		
		if(maquinaRecuperada.isEmpty())
			throw new BadRequestException(String.format("La maquina con ID: %d no existe",id));
		
		return new ResponseEntity<Maquina>(maquinaRecuperada.get(),HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?>addMaquina(@Valid @RequestBody Maquina maquina, BindingResult result){
		
	
		
		if(result.hasErrors())
			return TarjetasUtils.getErrors(result);
		
		return new ResponseEntity<Maquina>(maquinaDAO.guardar(maquina),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAllMaquinas(){
		
		List<Maquina>maquinas= (List<Maquina>) maquinaDAO.buscarTodos();
		
		if(maquinas.isEmpty())
			throw new BadRequestException("No hay maquinas dadas de alta en la base de datos");
		
		return new ResponseEntity<List<Maquina>>(maquinas,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMaquina(@RequestParam(name="id")Integer id){
	Map<String, Object> respuesta = new HashMap<String, Object>();
	Optional<Maquina>maquinaRecuperada= maquinaDAO.buscarPorID(id);
		
		if(maquinaRecuperada.isEmpty())
			throw new BadRequestException(String.format("La maquina con ID: %d no existe",id));
		
		maquinaDAO.eliminarPorId(id);
		respuesta.put("OK", "Maquina ID: " + id + " eliminado exitosamente{"+maquinaRecuperada.get().toString()+"}");
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
		
	}
	
	

}
