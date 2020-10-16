package com.pruebatecnica.app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.app.entidades.Categorias;

@Repository
public interface CategoriasRepo extends CrudRepository<Categorias, Integer> {

	@Query("Select u FROM Categorias u WHere u.nombre = :nombre")
	public Categorias getCategoriaByNombre(@Param("nombre") String nombre);

}
