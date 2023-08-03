package com.ios.tarjetas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sound.sampled.Line;
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

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.entities.Linea;
import com.ios.tarjetas.exceptions.BadRequestException;
import com.ios.tarjetas.services.AreaDAO;
import com.ios.tarjetas.services.LineaDAO;
import com.ios.tarjetas.utils.TarjetasUtils;

@RestController
@RequestMapping("/linea")
public class LineaController {

	@Autowired
	LineaDAO lineaDAO;

	@Autowired
	AreaDAO areaDAO;

	@GetMapping("/get")
	public ResponseEntity<?> getLinea(@RequestParam(name = "id") Integer id) {

		Optional<Linea> lineaObtenida = lineaDAO.buscarPorID(id);
		if (!lineaObtenida.isPresent())
			throw new BadRequestException(String.format("El tarjeta con ID: %d no existe", id));

		return new ResponseEntity<Linea>(lineaObtenida.get(), HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<?> addLinea(@Valid @RequestBody Linea linea, BindingResult result) {

		if (result.hasErrors())
			return TarjetasUtils.getErrors(result);

		Linea lienaGuardada = lineaDAO.guardar(linea);

		return new ResponseEntity<Linea>(lienaGuardada, HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public ResponseEntity<?> obtenerTodasLineas() {

		List<Linea> lineas = (List<Linea>) lineaDAO.buscarTodos();

		if (lineas.isEmpty())
			throw new BadRequestException("No hya lineas dadas de alta");

		return new ResponseEntity<List<Linea>>(lineas, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> eliminarLinea(@RequestParam(name = "id") Integer id) {

		Optional<Linea> lineaEncontrado = lineaDAO.buscarPorID(id);
		Map<String, Object> respuesta = new HashMap<String, Object>();

		if (lineaEncontrado.isEmpty())
			throw new BadRequestException(String.format("La linea con ID: %d no existe", id));

		lineaDAO.eliminarPorId(id);
		respuesta.put("OK", "Linea ID: " + id + " eliminado exitosamente{" + lineaEncontrado.get().toString() + "}");

		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);

	}

	@GetMapping("/setArea")
	public ResponseEntity<?> agregarLineaAArea(@RequestParam(name = "idLinea") Integer idLinea,
			@RequestParam(name = "idArea") Integer idArea) {
		Optional<Linea> lineaObtenida = lineaDAO.buscarPorID(idLinea);
		if (!lineaObtenida.isPresent())
			throw new BadRequestException(String.format("El tarjeta con ID: %d no existe", idLinea));

		Optional<Area> areaObteneida = areaDAO.buscarPorID(idArea);
		if (!areaObteneida.isPresent())
			throw new BadRequestException(String.format("El tarjeta con ID: %d no existe", idArea));
		
		Linea lienaModificada=lineaDAO.asociarAreaALineas(lineaObtenida.get(), areaObteneida.get());
		
		return new ResponseEntity<Linea>(lienaModificada,HttpStatus.OK);
	}

}
