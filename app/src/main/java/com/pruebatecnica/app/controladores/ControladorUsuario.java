package com.pruebatecnica.app.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.app.entidades.Usuario;
import com.pruebatecnica.app.excepciones.RecursoNoEncontradoExcepcion;
import com.pruebatecnica.app.repositorio.UsuarioRepo;





@RestController
@RequestMapping("/api/v1")
public class ControladorUsuario {
	
	
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	
	// get usuarios
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios(){
		return this.usuarioRepo.findAll();
		}
	
	// get usuario por id
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuarioPorId(@PathVariable(value = "id") Integer id) {
		return this.usuarioRepo.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));
	}
	
	//post(crear) usuario
	@PostMapping("/usuarios")
	public Usuario crearUsuario( @RequestBody Usuario usuario) {
		return this.usuarioRepo.save(usuario);
	}
	
	
	//put(update) usuario
	
	@PutMapping("/usuarios/{id}")
	public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable ("id") Integer id) {
		Usuario usuarioActual = this.usuarioRepo.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellido(usuario.getApellido());
		usuarioActual.setNivel(usuario.getNivel());
		usuarioActual.setEstado(usuario.getEstado());
		usuarioActual.setPass(usuario.getPass());
		return this.usuarioRepo.save(usuarioActual);
	}
	
	
	
	//borrar/desactivar por id
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> deactivarUsuario( @PathVariable ("id") Integer id) {
		Usuario usuarioActual = this.usuarioRepo.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));
		
	
	   this.usuarioRepo.delete(usuarioActual);
	   return ResponseEntity.ok().build();
	}
	
		
		
	}
