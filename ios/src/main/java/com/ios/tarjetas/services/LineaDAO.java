package com.ios.tarjetas.services;

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.entities.Linea;

public interface LineaDAO extends GenericoDAO<Linea> {
	public Linea asociarAreaALineas(Linea linea, Area area);
}
