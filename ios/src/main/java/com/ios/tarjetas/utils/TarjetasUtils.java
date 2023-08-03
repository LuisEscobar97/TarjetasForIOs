package com.ios.tarjetas.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class TarjetasUtils {
	public static ResponseEntity<Map<String, Object>> getErrors(BindingResult result) {
		Map<String, Object> validaciones = new HashMap<String, Object>();

		List<String> listaErrores = result.getFieldErrors().stream()
				.map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
				.collect(Collectors.toList());

		validaciones.put("Lista de errores", listaErrores);
		return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);

	}
}
