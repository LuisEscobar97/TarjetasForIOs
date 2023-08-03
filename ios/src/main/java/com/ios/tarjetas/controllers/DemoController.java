package com.ios.tarjetas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.services.AreaDAO;




@RestController
@RequestMapping("/api")
public class DemoController {
	
	@Autowired
	private AreaDAO areaDAO;
	
	
	@GetMapping("/hello")
	public String demo() {
		
		Area area = new Area(1, "Cocolates");
		areaDAO.guardar(area);
		
		return areaDAO.buscarPorID(1).toString();
	}
	

}
