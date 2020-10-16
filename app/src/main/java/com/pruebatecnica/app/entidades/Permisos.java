package com.pruebatecnica.app.entidades;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Permisos")
public class Permisos {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_permiso", nullable = false)
	private String nombre_permiso;

	
	
	@ManyToMany(mappedBy = "permisos", cascade = CascadeType.MERGE)
	@JsonBackReference
	private Set<Usuario> usuarios;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getnombre_permiso() {
		return nombre_permiso;
	}

	public void setnombre_permiso(String nombre_permiso) {
		this.nombre_permiso = nombre_permiso;
	}

	public Set<Usuario> getUsuarios() {
		
		if (usuarios == null) {
			usuarios = new HashSet();
	    }
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setIdPorNombre(String nombre_permiso) {

		if(nombre_permiso.equals("ADMIN")) {
			this.setId(1);
		}else if(nombre_permiso.equals("USER"))
			
			this.setId(2);
		
	}
	

	
	
	
	

	
	
	
	
	
}
