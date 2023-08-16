package com.ios.tarjetas.services;

import com.ios.tarjetas.entities.Componente;
import com.ios.tarjetas.entities.Maquina;

public interface ComponenteDAO extends GenericoDAO<Componente>{
	public Componente asociarComponenteMaquina(Componente componente, Maquina maquina);
}
