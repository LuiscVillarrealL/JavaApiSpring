package com.pruebatecnica.app.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Permisos")
public class Permisos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre_permiso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_permiso() {
		return nombre_permiso;
	}

	public void setNombre_permiso(String nombre_permiso) {
		this.nombre_permiso = nombre_permiso;
	}
	
	
	
	

	
	
	
	
	
}
