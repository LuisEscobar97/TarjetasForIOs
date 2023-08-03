package com.ios.tarjetas.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "linea")
public class Linea implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String nombre;
	
	@ManyToOne(optional = true,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "area_id",foreignKey = @ForeignKey(name = "FK_AREA_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "lineas"})
	private Area area;
	

	@OneToMany(mappedBy = "linea")
	@JsonIgnoreProperties({ "linea" })
	private List<Maquina>maquinas;
	
	

	public Linea() {
		super();
	}

	public Linea(Integer id,String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Linea {id=" + id + ", nombre=" + nombre + "}";
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	
	
}
