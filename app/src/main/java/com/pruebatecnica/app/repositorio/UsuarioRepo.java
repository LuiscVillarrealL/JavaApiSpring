package com.pruebatecnica.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.app.entidades.Usuario;
import com.sun.el.stream.Optional;



@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{

	@Query("Select u FROM Usuario u WHere u.usuario = :usuario")
	public Usuario getUserByUsuario(@Param("usuario") String ususario);
	
	
}
