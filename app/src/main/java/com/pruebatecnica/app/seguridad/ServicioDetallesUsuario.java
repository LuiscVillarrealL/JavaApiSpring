package com.pruebatecnica.app.seguridad;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class ServicioDetallesUsuario implements UserDetailsService {

	@Override
	public DetallesUsuario loadUserByUsername(String usuario) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new DetallesUsuario(usuario);
	}

	
}
