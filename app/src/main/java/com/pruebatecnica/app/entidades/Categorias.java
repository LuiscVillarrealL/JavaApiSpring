package com.pruebatecnica.app.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Categorias")
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "ult_actualizacion")
	private Date ult_actualizacion;

	@Column(name = "estado", nullable = false)
	private String estado;

	@ManyToMany(mappedBy = "categorias", cascade = CascadeType.MERGE)
	@JsonBackReference
	private Set<Productos> productos;

	public Categorias() {

	}

	public Categorias(String nombre) {
		this.nombre = nombre;
		setFecha_creacion();
		this.estado = "activo";

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	@PrePersist
	public void setFecha_creacion() {
		this.fecha_creacion = new Date();
		System.out.println("Se creo un esta categoria el " + fecha_creacion);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<Productos> getProductos() {
		if (productos == null) {
			productos = new HashSet();
		}

		return productos;
	}

	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}

	public Date getUlt_actualizacion() {
		return ult_actualizacion;
	}

	public void setUlt_actualizacion() {
		this.ult_actualizacion = new Date();
		System.out.println("Ultimo ingreso: " + ult_actualizacion);
	}

	//

}
