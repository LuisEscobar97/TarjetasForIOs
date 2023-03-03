package com.tarjetas.ios.demo.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.NonFinal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "colaboradores", schema = "tarjetas")
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String nombre;

	@Column(name = "apellido", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String apellido;

	@Column(name = "correo", nullable = false, unique = true)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String correo;

	@OneToMany(mappedBy = "colaborador")
	@JsonIgnoreProperties({ "colaborador" })
	private List<Tarjeta> tarjetas;
	
	

	public Colaborador(Integer id,String nombre,String apellido, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Colaborador {id=" + id + 
				", nombre=" + nombre + 
				", apellido=" + apellido + 
				", correo=" + correo + 
				"}";
	}

}
