package com.ios.tarjetas.entities;

import java.io.Serializable;
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
@NoArgsConstructor
@Table(name = "colaboradores")
public class Colaborador implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

}
