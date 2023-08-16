package com.ios.tarjetas.services;

import com.ios.tarjetas.entities.Linea;
import com.ios.tarjetas.entities.Maquina;

public interface MaquinaDAO extends GenericoDAO<Maquina>{
	
	public Maquina asociarMaquinaLinea(Maquina maquina, Linea linea);

}
