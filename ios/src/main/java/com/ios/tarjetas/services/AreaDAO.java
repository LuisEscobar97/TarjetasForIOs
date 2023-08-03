package com.ios.tarjetas.services;

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.entities.Linea;

public interface AreaDAO extends GenericoDAO<Area>{
	public Area asociarLineaAArea(Linea linea, Area area);
}
