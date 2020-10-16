package com.pruebatecnica.app.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pruebatecnica.app.entidades.Usuario;
import com.pruebatecnica.app.repositorio.UsuarioRepo;

@Service
public class ServicioDetallesUsuario implements UserDetailsService {

	@Autowired
	private UsuarioRepo usuarioRepo;

	@Override
	public DetallesUsuario loadUserByUsername(String usuarioNom) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepo.getUserByUsuario(usuarioNom);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario: " + usuarioNom + " no encontrado");
		}

		return new DetallesUsuario(usuario);

	}

}
