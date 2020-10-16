package com.pruebatecnica.app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.app.entidades.Permisos;

@Repository
public interface PermisosRepo extends CrudRepository<Permisos, Integer> {

	@Query("Select u FROM Permisos u WHere u.nombre_permiso = :nombre_permiso")
	public Permisos getPermisosByNombre(@Param("nombre_permiso") String nombre_permiso);

}