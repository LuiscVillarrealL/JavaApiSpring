package com.pruebatecnica.app.seguridad;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SeguridadConf extends WebSecurityConfigurerAdapter{

	@Bean
    public UserDetailsService userDetailsService() {
        return new ServicioDetallesUsuario();
    }
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	
	//autorizacion 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		//http.cors().and().csrf().disable();
		
		http.authorizeRequests().antMatchers("/api/v1/usuarios/").hasAuthority("ADMIN")
								.antMatchers("/api/v1/categorias/").hasAnyAuthority("ADMIN","USUARIO")
								.antMatchers("/api/v1/productos/").hasAnyAuthority("ADMIN","USUARIO")
								.anyRequest().authenticated()
					            .and()
					            .formLogin().permitAll()
					            .and()
					            .logout().permitAll()
					            .and()
					            .exceptionHandling().accessDeniedPage("/403")
					            ;
		
		
	}
	
	


	
	
	

}
