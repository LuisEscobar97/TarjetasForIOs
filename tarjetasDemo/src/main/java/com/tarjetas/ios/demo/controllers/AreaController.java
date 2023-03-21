package com.tarjetas.ios.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tarjetas.ios.demo.entities.Area;
import com.tarjetas.ios.demo.services.AreaDAO;

@RestController
@RequestMapping("/api")
public class AreaController {
	
	
	
	@GetMapping("/crear")
	private String creaArea() {
		
		
		
		return"creado";
	}

}
