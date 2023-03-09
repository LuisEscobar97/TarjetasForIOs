package com.tarjetas.ios.demo.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tarjetas.ios.demo.enums.Afectacion;
import com.tarjetas.ios.demo.enums.Prioridad;
import com.tarjetas.ios.demo.enums.StatusCierre;
import com.tarjetas.ios.demo.enums.StatusTarjeta;
import com.tarjetas.ios.demo.enums.TipoTarjeta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tarjeta",schema = "tarjetas")
public class Tarjeta {
	
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
	
	@Column(name = "status_cierre",nullable = false)
	private StatusCierre statusCierre;
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "colaborador_id",foreignKey = @ForeignKey(name = "FK_COLABORADOR_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetas"})
	private Colaborador colaborador;
	
	@ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "componente_id",foreignKey = @ForeignKey(name = "FK_COMPONENTE_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetas"})
	private Componente componente;
	
	

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



	@Override
	public String toString() {
		return "Tarjeta {id=" + id + ", tipoTarjeta=" + tipoTarjeta + ", prioridad=" + prioridad + ", comentario="
				+ comentario + ", descripcion=" + descripcion + ", status=" + status + ", afectacion=" + afectacion
				+ ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", fechaObjetivo="
				+ fechaObjetivo + ", statusCierre=" + statusCierre + "}";
	}

	
	
	
}
