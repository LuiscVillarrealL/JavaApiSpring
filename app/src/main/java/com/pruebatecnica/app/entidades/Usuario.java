package com.pruebatecnica.app.entidades;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



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
	
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	
	//permisos
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  //En caso de agregar diferentes tipos de roles se mantiene la relacion mucho a much
	@JoinTable(
			name="permisos_usuario",
			
			
			joinColumns = {
					@JoinColumn(name = "usuario_id", referencedColumnName = "id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "permisos_id", referencedColumnName = "id")
			}
			
			)
	 @JsonManagedReference
	private Set<Permisos> permisos = new HashSet();
	
	
	

	
	
	
	
	


	
	
	
	public Usuario(String nombre, String apellido, String usuario, String pass
) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.pass = pass;
		setFechaCreacion();
		this.setEstado("activo");

		
	}
	
	

	
	

	



	public Usuario() {
		
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
		System.out.println("Se creo un usuario el " + fecha_creacion);
	}
	public Date getUltIngreso() {
		return ult_ingreso;
	}
	
	

	public void setUltIngreso() {
		this.ult_ingreso = new Date();
		System.out.println("Ultimo ingreso: " +ult_ingreso);
	}

	
	


	public Set<Permisos> getPermisos() {
		if(permisos == null) {
			permisos = new HashSet();
		}
		return permisos;
	}

	public void setPermisos(Set<Permisos> permisos) {
		this.permisos = permisos;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public Date getUlt_ingreso() {
		return ult_ingreso;
	}



	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}



	public boolean isEnabled() {
		
		return this.estado.equals("activo");
	}
	

	

	

}
