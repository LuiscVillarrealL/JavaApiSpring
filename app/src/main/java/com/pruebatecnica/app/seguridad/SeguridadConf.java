package com.pruebatecnica.app.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SeguridadConf extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	//autenticacion
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub

		
		auth.userDetailsService(userDetailsService);
	}

	
	//autorizacion 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors().and().csrf().disable();
		
		
		http.authorizeRequests().antMatchers("/api/v1/usuarios").hasRole("ADMIN")
								.antMatchers("/categorias").hasAnyRole("ADMIN","USUARIO")
								.antMatchers("/productos").hasAnyRole("ADMIN","USUARIO")
								.and().formLogin();
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder getPasswordEnconder() {
		return NoOpPasswordEncoder.getInstance();
    	
    	
    }
	

	
	
	

}
