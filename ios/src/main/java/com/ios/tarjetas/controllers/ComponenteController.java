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

import com.ios.tarjetas.entities.Componente;
import com.ios.tarjetas.entities.Linea;
import com.ios.tarjetas.entities.Maquina;
import com.ios.tarjetas.exceptions.BadRequestException;
import com.ios.tarjetas.services.ComponenteDAO;
import com.ios.tarjetas.services.MaquinaDAO;
import com.ios.tarjetas.utils.TarjetasUtils;

@RestController
@RequestMapping("/componente")
public class ComponenteController {
	@Autowired
	private ComponenteDAO componenteDAO;
	
	@Autowired
	private MaquinaDAO maquinaDAO;

	@GetMapping("/get")
	public ResponseEntity<?> getComponenteById(@RequestParam(name = "id") Integer id) {
		Optional<Componente> compoObtenido = componenteDAO.buscarPorID(id);

		if (!compoObtenido.isPresent())
			throw new BadRequestException(String.format("El coponete con el id %d no se encontrò", id));

		return new ResponseEntity<Componente>(compoObtenido.get(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addComponente(@Valid @RequestBody Componente componente, BindingResult result) {
		if (result.hasErrors())
			return TarjetasUtils.getErrors(result);

		Componente componenteAdded = componenteDAO.guardar(componente);

		return new ResponseEntity<Componente>(componenteAdded, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllComponents() {
		List<Componente> listaComponentes = (List<Componente>) componenteDAO.buscarTodos();
		if (listaComponentes.isEmpty())
			throw new BadRequestException("No hay componentes dados de alta");

		return new ResponseEntity<List<Componente>>(listaComponentes, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<?> deletComponente(@RequestParam(name = "id") Integer id) {

		Optional<Componente> compoObtenido = componenteDAO.buscarPorID(id);

		if (!compoObtenido.isPresent())
			throw new BadRequestException(String.format("El coponete con el id %d no se encontrò", id));

		componenteDAO.eliminarPorId(id);

		return new ResponseEntity<Componente>(compoObtenido.get(), HttpStatus.OK);
	}
	
	@GetMapping("/setMaquina")
	public ResponseEntity<?> agregarMaquinaAComponente(@RequestParam(name = "idMaquina") Integer idMaquina,
			@RequestParam(name = "idComponente") Integer idComponente) {
		Optional<Maquina> maquinaObtenida = maquinaDAO.buscarPorID(idMaquina);
		if (!maquinaObtenida.isPresent())
			throw new BadRequestException(String.format("El tarjeta con ID: %d no existe", idMaquina));

		Optional<Componente> componenteObteneida = componenteDAO.buscarPorID(idComponente);
		if (!componenteObteneida.isPresent())
			throw new BadRequestException(String.format("El tarjeta con ID: %d no existe", idComponente));
		
		Componente componenteMod= componenteDAO.asociarComponenteMaquina(componenteObteneida.get(), maquinaObtenida.get());
		
		return new ResponseEntity<Componente>(componenteMod,HttpStatus.OK);
	}

}
