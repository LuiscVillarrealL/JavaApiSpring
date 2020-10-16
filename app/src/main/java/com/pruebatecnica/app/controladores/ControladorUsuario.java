package com.pruebatecnica.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.app.entidades.Permisos;
import com.pruebatecnica.app.entidades.Usuario;
import com.pruebatecnica.app.excepciones.RecursoNoEncontradoExcepcion;
import com.pruebatecnica.app.postobj.UsuarioPost;
import com.pruebatecnica.app.repositorio.PermisosRepo;
import com.pruebatecnica.app.repositorio.UsuarioRepo;

@RestController
@RequestMapping("/api/v1")
public class ControladorUsuario {

	@Autowired
	private UsuarioRepo usuarioRepo;

	@Autowired
	private PermisosRepo permisosRepo;

	// 'GET' usuarios
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		return (List<Usuario>) this.usuarioRepo.findAll();
	}

	// 'GET' usuario por id
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuarioPorId(@PathVariable(value = "id") Integer id) throws  RecursoNoEncontradoExcepcion{
		return this.usuarioRepo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));
	}

	// 'POST'(crear) usuario
	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestBody UsuarioPost post) throws RecursoNoEncontradoExcepcion {

		String nombre = post.getNombre();
		String usuario_nom = post.getUsuario();
		String pass = post.getPass();
		String nombre_permiso = post.getPermiso();
		String apellido = post.getApellido();

		Usuario usuario = new Usuario(nombre, apellido, usuario_nom, pass);


		Permisos permiso = this.permisosRepo.getPermisosByNombre(nombre_permiso);

		if (permiso == null) {
			throw new RecursoNoEncontradoExcepcion("Permiso: " + permiso + " no encontrado");
		}

		permiso.getUsuarios().add(usuario);
		usuario.getPermisos().add(permiso);

		return this.usuarioRepo.save(usuario);
	}

	// 'PUT' (update) usuario
	@PutMapping("/usuarios/{id}")
	public Usuario updateUsuario(@RequestBody UsuarioPost post, @PathVariable("id") Integer id) {
		Usuario usuarioActual = this.usuarioRepo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));
		usuarioActual.setNombre(post.getNombre());
		usuarioActual.setApellido(post.getApellido());
		usuarioActual.setEstado(post.getEstado());
		usuarioActual.setPass(post.getPass());
		usuarioActual.setUltIngreso();

		Permisos permiso = this.permisosRepo.getPermisosByNombre(post.getPermiso());

		if (permiso == null) {
			throw new UsernameNotFoundException("Permiso: " + permiso + " no encontrado");
		}

		
		//Para actualizar, se borran todos los permisos y se agregan denuevo con los nuevos
		usuarioActual.getPermisos().clear();
		permiso.getUsuarios().remove(usuarioActual);

		permiso.getUsuarios().add(usuarioActual);
		usuarioActual.getPermisos().add(permiso);

		return this.usuarioRepo.save(usuarioActual);
	}

	
	/*
	// borrar/desactivar por id

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> deactivarUsuario(@PathVariable("id") Integer id) {
		Usuario usuarioActual = this.usuarioRepo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));

		this.usuarioRepo.delete(usuarioActual);
		return ResponseEntity.ok().build();
	}*/

}
