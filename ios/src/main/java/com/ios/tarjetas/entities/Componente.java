package com.ios.tarjetas.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "componente")
public class Componente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String nombre;
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "maquina_id",foreignKey = @ForeignKey(name = "FK_MAQUINA_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "componentes"})
	private Maquina maquina;
	
	@OneToMany(mappedBy = "componente")
	@JsonIgnoreProperties({"componente"})
	private List<Tarjeta>tarjetas;
	
	
	public Componente(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Componente [id=" + id + ", nombre=" + nombre + "]";
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


	public Maquina getMaquina() {
		return maquina;
	}


	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}


	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}


	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	
}
