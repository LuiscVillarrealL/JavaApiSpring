package com.pruebatecnica.app.entidades;

public class UsuarioPost {

	private String nombre;
	private String apellido;
	private String usuario;
	private String pass;
	private String permiso;
	private String estado;

	public UsuarioPost(String nombre, String apellido, String usuario, String pass, String permiso) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.pass = pass;
		this.permiso = permiso;

	}
	public UsuarioPost(String nombre, String apellido, String usuario, String pass, String permiso, String estado) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.pass = pass;
		this.permiso = permiso;
		this.estado = estado;

	}
	
	
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public UsuarioPost() {
		
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	
	

}
