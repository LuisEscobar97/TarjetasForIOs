package com.tarjetas.ios.demo.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "linea",schema = "tarjetas")
public class Linea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String nombre;
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id",foreignKey = @ForeignKey(name = "FK_AREA_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "lineas"})
	private Area area;
	
	@OneToMany(mappedBy = "linea")
	@JsonIgnoreProperties({ "linea" })
	private List<Maquina>maquinas;

	public Linea(Integer id,String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Linea {id=" + id + ", nombre=" + nombre + "}";
	}
	
}
