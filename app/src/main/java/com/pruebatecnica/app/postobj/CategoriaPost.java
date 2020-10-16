package com.pruebatecnica.app.postobj;

import java.util.List;

public class CategoriaPost {

	
	private String nombre;
	private String estado;

	
	
	
	
	public CategoriaPost(String nombre) {
		this.nombre = nombre;
	}
	
	
	public CategoriaPost(String nombre, String estado) {

		this.nombre = nombre;
		this.estado = estado;
	}

	
	
	
	

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
