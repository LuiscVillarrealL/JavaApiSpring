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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;



import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Productos")
public class Productos {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "costo")
	private Float costo;
	
	@Column(name = "precio")
	private Float precio;
	
	@Column(name = "tags")
	private String tags; //ver como separar los tags
	
	@Column(name = "estado", nullable = false)
	private String estado;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ult_actualizacion")
	private Date ult_actualizacion;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name="categorias_productos",
			
			
			joinColumns = {
					@JoinColumn(name = "productos_id", referencedColumnName = "id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "categoria_id", referencedColumnName = "id")
			}
			
			)
	 @JsonManagedReference
	private Set<Categorias> categorias = new HashSet();


	
	
	
	
	
	
	public Productos(String nombre, Float costo, Float precio, String tags) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.precio = precio;
		this.tags = tags;
		this.setEstado("activo");
		setFechaCreacion();
	}

	public Productos() {
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	@PrePersist
	public void setFechaCreacion() {
		this.fecha_creacion = new Date();
		System.out.println("Se creo un usuario el " + fecha_creacion);
	}


	public Date getUlt_actualizacion() {
		return ult_actualizacion;
	}




	public void setUlt_actualizacion() {
		this.ult_actualizacion = new Date();
		System.out.println("Ultimo ingreso: " + ult_actualizacion);
	}


	public Set<Categorias> getCategorias() {
		
		if(categorias == null) {
			categorias = new HashSet();
		}
		return categorias;
	}


	public void setCategorias(Set<Categorias> categorias) {
		this.categorias = categorias;
	};
	
	public boolean isEnabled() {
		
		return this.estado.equals("activo");
	}
	
	
	
	


}
