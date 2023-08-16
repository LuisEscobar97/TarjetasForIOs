package com.ios.tarjetas.services;

import com.ios.tarjetas.entities.Componente;
import com.ios.tarjetas.entities.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta>{
	public Tarjeta asociarComponenteTarjeta(Componente componente, Tarjeta tarjeta);
}
