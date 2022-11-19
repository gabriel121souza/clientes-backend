package br.com.cursoSpringAngular.cursoSpringAngular.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//Configuração das rotas que precisa de autenticaçao
@Configuration
@EnableResourceServer
public class ResourceServeConfig extends ResourceServerConfigurerAdapter{
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			//.antMatchers("/api/clientes/**").hasRole("USER")
			.antMatchers("/api/usuarios/**").permitAll()
			.antMatchers("/api/clientes/**", 
					"/api/servicos-prestados/**").authenticated()
			.anyRequest().denyAll();
			
	}
}
