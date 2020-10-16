package com.pruebatecnica.app.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.app.entidades.Productos;

@Repository
public interface ProductosRepo extends CrudRepository<Productos, Integer> {

	@Query("Select u FROM Productos u WHere u.nombre = :nombre")
	public Productos getProductoByNombre(@Param("nombre") String nombre);

}
