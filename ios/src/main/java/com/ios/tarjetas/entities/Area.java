package com.ios.tarjetas.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "area")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String nombre;
	
	
	@OneToMany(mappedBy = "area",fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "area" })
	private Set<Linea>lineas;
	

	public Area() {
		super();
	}

	public Area(Integer id,String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Area {id=" + id + ", nombre=" + nombre + "}";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Linea> getLineas() {
		return lineas;
	}

	public void setLineas(Set<Linea> lineas) {
		this.lineas = lineas;
	}
	
	
}
