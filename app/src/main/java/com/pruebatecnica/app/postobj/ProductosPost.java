package com.pruebatecnica.app.postobj;

import java.util.List;


//Clase para hacer POST/PUT a productos

public class ProductosPost {

	private String nombre;
	private Float costo;
	private Float precio;
	private String tags;
	private String estado;
	private List<String> categorias;

	//Usado en POST
	public ProductosPost(String nombre, Float costo, Float precio, String tags, List<String> categorias) {

		this.nombre = nombre;
		this.costo = costo;
		this.precio = precio;
		this.tags = tags;
		this.categorias = categorias;
	}

	//Usado en PUT
	public ProductosPost(String nombre, Float costo, Float precio, String tags, List<String> categorias,
			String estado) {

		this.nombre = nombre;
		this.costo = costo;
		this.precio = precio;
		this.tags = tags;
		this.estado = estado;
		this.categorias = categorias;
	}

	public ProductosPost() {

	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
