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

import com.pruebatecnica.app.entidades.Categorias;

import com.pruebatecnica.app.entidades.Usuario;
import com.pruebatecnica.app.excepciones.RecursoNoEncontradoExcepcion;
import com.pruebatecnica.app.postobj.CategoriaPost;

import com.pruebatecnica.app.repositorio.CategoriasRepo;

import com.pruebatecnica.app.repositorio.ProductosRepo;

@RestController
@RequestMapping("/api/v1")
public class ControladorCategoria {

	@Autowired
	private CategoriasRepo categoriasRepo;

	// get categorias
	@GetMapping("/categorias")
	public List<Categorias> getAllCategorias() {
		return (List<Categorias>) this.categoriasRepo.findAll();
	}

	// get categorias por id
	@GetMapping("/categorias/{id}")
	public Categorias getCategoriaPorId(@PathVariable(value = "id") Integer id) {
		return this.categoriasRepo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("Categorias no encontrado"));
	}

	// post(crear) categoria
	@PostMapping("/categorias")
	public Categorias crearCategoria(@RequestBody CategoriaPost post) throws Exception {

		
		
		String nombre = post.getNombre();

		Categorias categoria = new Categorias(nombre);

		return this.categoriasRepo.save(categoria);
	}

	// put(update) categorias

	@PutMapping("/categorias/{id}")
	public Categorias updateCategorias(@RequestBody CategoriaPost post, @PathVariable("id") Integer id) {
		Categorias categoriasActual = this.categoriasRepo.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoExcepcion("categoria no encontrada"));

		categoriasActual.setNombre(post.getNombre());
		categoriasActual.setUlt_actualizacion();

		if (post.getEstado() != null) {
			categoriasActual.setEstado(post.getEstado());
		}

		return this.categoriasRepo.save(categoriasActual);
	}

	// borrar/desactivar por id

	@DeleteMapping("/categoriasRepo/{id}")
	public ResponseEntity<Usuario> deactivarUsuario(@PathVariable("id") Integer id) {
		// Usuario usuarioActual = this.categoriasRepo.findById(id).orElseThrow(() ->
		// new RecursoNoEncontradoExcepcion("Usuario no encontrado"));

		return null;
	}

}
