package com.pruebatecnica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.entidades.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{

	
}
