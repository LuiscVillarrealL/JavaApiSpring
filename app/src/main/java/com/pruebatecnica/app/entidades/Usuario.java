package com.pruebatecnica.app.entidades;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "usuario", nullable = false)
	private String usuario;
	
	@Column(name = "pass", nullable = false)
	private String pass;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ult_ingreso")
	private Date ult_ingreso;
	
	@Column(name = "nivel", nullable = false)
	private String nivel;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	
	
	
	
	
	public Usuario() {
		super();
	}


	public Usuario(String nombre, String apellido, String usuario, String pass,
			 String nivel) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.pass = pass;
		this.setFechaCreacion();
		this.nivel = nivel;
		this.estado = "Activo";
	}
	
	
	public int getId() {
		return id;
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
	public Date getFechaCreacion() {
		return fecha_creacion;
	}
	
	@PrePersist
	public void setFechaCreacion() {
		this.fecha_creacion = new Date();
		System.out.println("Se creo un ususario el " + fecha_creacion);
	}
	public Date getUltIngreso() {
		return ult_ingreso;
	}
	public void setUltIngreso(Date ult_ingreso) {
		this.ult_ingreso = ult_ingreso;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	

}
