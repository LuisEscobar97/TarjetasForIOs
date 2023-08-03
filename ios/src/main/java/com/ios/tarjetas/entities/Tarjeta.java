package com.ios.tarjetas.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ios.tarjetas.enums.Afectacion;
import com.ios.tarjetas.enums.Prioridad;
import com.ios.tarjetas.enums.StatusTarjeta;
//import com.tarjetas.ios.demo.enums.Afectacion;
//import com.tarjetas.ios.demo.enums.Prioridad;
//import com.tarjetas.ios.demo.enums.StatusCierre;
//import com.tarjetas.ios.demo.enums.StatusTarjeta;
//import com.tarjetas.ios.demo.enums.TipoTarjeta;
import com.ios.tarjetas.enums.TipoTarjeta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Entity
@NoArgsConstructor
@Table(name = "tarjeta")
public class Tarjeta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo_tarjeta",nullable = false)
	private TipoTarjeta tipoTarjeta;
	
	@Column(name = "prioridad",nullable = false)
	private Prioridad prioridad;
	
	@Column(name = "comentario", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String comentario;
	
	@Column(name = "descripcion", nullable = false)
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	private String descripcion;
	
	@Column(name = "status",nullable = false)
	private StatusTarjeta status;
	
	@Column(name = "afectacion",nullable = false)
	private Afectacion afectacion;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "fecha_cierre")
	private Date fechaCierre;
	
	@Column(name = "fecha_objetivo")
	private Date fechaObjetivo;
	
	//@Column(name = "status_cierre",nullable = false)
	//private StatusCierre statusCierre;
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "colaborador_id",foreignKey = @ForeignKey(name = "FK_COLABORADOR_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetas"})
	private Colaborador colaborador;
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "componente_id",foreignKey = @ForeignKey(name = "FK_COMPONENTE_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetas"})
	private Componente componente;
	
	
/*
	public Tarjeta(Integer id, TipoTarjeta tipoTarjeta, Prioridad prioridad,String comentario,String descripcion,StatusTarjeta status, Afectacion afectacion) {
		super();
		this.id = id;
		this.tipoTarjeta = tipoTarjeta;
		this.prioridad = prioridad;
		this.comentario = comentario;
		this.descripcion = descripcion;
		this.status = status;
		this.afectacion = afectacion;
	}

*/

	@Override
	public String toString() {
		return "Tarjeta {id=" + id +  ", comentario="
				+ comentario + ", descripcion=" + descripcion +  ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", fechaObjetivo="
				+ fechaObjetivo + "}";
	}


	public Tarjeta(Integer id, String comentario, String descripcion,Colaborador colaborador, Componente componente) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.descripcion = descripcion;
		this.colaborador = colaborador;
		this.componente = componente;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}


	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}


	public Prioridad getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public StatusTarjeta getStatus() {
		return status;
	}


	public void setStatus(StatusTarjeta status) {
		this.status = status;
	}


	public Afectacion getAfectacion() {
		return afectacion;
	}


	public void setAfectacion(Afectacion afectacion) {
		this.afectacion = afectacion;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Date getFechaCierre() {
		return fechaCierre;
	}


	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}


	public Date getFechaObjetivo() {
		return fechaObjetivo;
	}


	public void setFechaObjetivo(Date fechaObjetivo) {
		this.fechaObjetivo = fechaObjetivo;
	}


	public Colaborador getColaborador() {
		return colaborador;
	}


	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}


	public Componente getComponente() {
		return componente;
	}


	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	
	
	
}
