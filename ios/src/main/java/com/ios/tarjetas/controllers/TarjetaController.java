package com.ios.tarjetas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.ios.tarjetas.entities.Componente;
import com.ios.tarjetas.entities.Maquina;
import com.ios.tarjetas.entities.Tarjeta;
import com.ios.tarjetas.exceptions.BadRequestException;
import com.ios.tarjetas.services.ComponenteDAO;
import com.ios.tarjetas.services.TarjetaDAO;
import com.ios.tarjetas.utils.TarjetasUtils;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

	@Autowired
	TarjetaDAO tarjetaDAO;
	
	@Autowired
	ComponenteDAO compoDAO;

	@GetMapping("/get")
	public ResponseEntity<?> getTarjeaById(@RequestParam(name = "id") Integer id) {

		Optional<Tarjeta> tarjetaEncontrada = tarjetaDAO.buscarPorID(id);

		if (!tarjetaEncontrada.isPresent())
			throw new BadRequestException(String.format("La tarjeta con ID: %d no existe", id));

		return new ResponseEntity<Tarjeta>(tarjetaEncontrada.get(), HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<?> addTarjeta(@Valid @RequestBody Tarjeta tarjeta, BindingResult result) {

		if (result.hasErrors())
			return TarjetasUtils.getErrors(result);

		return new ResponseEntity<Tarjeta>(tarjetaDAO.guardar(tarjeta), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllTarjetas() {
		List<Tarjeta> listatarjetas = (List<Tarjeta>) tarjetaDAO.buscarTodos();

		if (listatarjetas.isEmpty())
			throw new BadRequestException("No hay tarjuetas dadas de alta");

		return new ResponseEntity<List<Tarjeta>>(listatarjetas, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteTarjetaById(@RequestParam(name = "id") Integer id) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		Optional<Tarjeta> tarjetaEncontrada = tarjetaDAO.buscarPorID(id);

		if (!tarjetaEncontrada.isPresent())
			throw new BadRequestException(String.format("La tarjeta con ID: %d no existe", id));
		
		tarjetaDAO.eliminarPorId(id);
		respuesta.put("OK", "Tarjeta ID: " + id + " eliminado exitosamente{"+tarjetaEncontrada.get().toString()+"}");
		
		return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
	}
	
	@GetMapping("/setComponente")
	public ResponseEntity<?> agregarMaquinaAComponente(@RequestParam(name = "idTarjeta") Integer idTarjeta,
			@RequestParam(name = "idComponente") Integer idComponente) {
		Optional<Componente> componenteObtenida =compoDAO.buscarPorID(idComponente);
		if (!componenteObtenida.isPresent())
			throw new BadRequestException(String.format("El tarjeta con ID: %d no existe", idComponente));

		Optional<Tarjeta> tarjetaObteneida = tarjetaDAO.buscarPorID(idTarjeta);
		if (!tarjetaObteneida.isPresent())
			throw new BadRequestException(String.format("El tarjeta con ID: %d no existe", idComponente));
		
		Tarjeta tarjetaMod= tarjetaDAO.asociarComponenteTarjeta(componenteObtenida.get(), tarjetaObteneida.get());
		
		return new ResponseEntity<Tarjeta>(tarjetaMod,HttpStatus.OK);
	}
}
