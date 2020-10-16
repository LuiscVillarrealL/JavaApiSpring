package com.pruebatecnica.app.seguridad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.pruebatecnica.app.entidades.Permisos;
import com.pruebatecnica.app.entidades.Usuario;

public class DetallesUsuario implements UserDetails{
	
	
	private Usuario usuario;
	
	public DetallesUsuario(Usuario usuario) {
		
		this.usuario=usuario;
		
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Permisos> permisos = usuario.getPermisos();
		List<SimpleGrantedAuthority> autoridades = new ArrayList<>();
		
		for(Permisos permiso : permisos) {
			
			autoridades.add(new SimpleGrantedAuthority(permiso.getnombre_permiso()));
		}
		
		System.out.println(autoridades);
		
		return autoridades;
	}

	



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usuario.getPass();
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.getUsuario();
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return usuario.isEnabled();
	}



	
}
