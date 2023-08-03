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

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.exceptions.BadRequestException;
import com.ios.tarjetas.services.AreaDAO;
import com.ios.tarjetas.utils.TarjetasUtils;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaDAO areaDAO;
	

    @GetMapping("/get")
    private ResponseEntity<?> obtenerTarjetas(@RequestParam(name = "id") Integer id){
        Optional<Area> tarjeta = areaDAO.buscarPorID(id);

        if (!tarjeta.isPresent())
            throw new BadRequestException(String.format("El tarjeta con ID: %d no existe",id));

        return new ResponseEntity<Area>(tarjeta.get(), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?>guardarTarjetas(@Valid @RequestBody Area area, BindingResult result){

       
        if (result.hasErrors())
        	return TarjetasUtils.getErrors(result);

        Area areaGuardada =  areaDAO.guardar(area);

        return new ResponseEntity<Area>( areaGuardada, HttpStatus.CREATED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?>obtenerTodosTarjetas(){

        List<Area> lsiatAreas= (List<Area>) areaDAO.buscarTodos();
        if (lsiatAreas.isEmpty())
            throw new BadRequestException("No hay areas dadas de alta en la base de datos");

        return new ResponseEntity<List<Area>>( lsiatAreas,HttpStatus.OK);


    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> eliminarTarjetas(@RequestParam(name = "id")Integer id){

        Optional<Area> areaEncontrado =areaDAO.buscarPorID(id);
        Map<String, Object> respuesta = new HashMap<String, Object>();

        if (!areaEncontrado.isPresent())
            throw new BadRequestException(String.format("El tarjeta con ID: %d no existe",id));


        areaDAO.eliminarPorId(id);
        respuesta.put("OK", "Area ID: " + id + " eliminado exitosamente{"+areaEncontrado.get().toString()+"}");

        return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.ACCEPTED);
    }


	
}
