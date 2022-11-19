package br.com.cursoSpringAngular.cursoSpringAngular.clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Usuario;
import br.com.cursoSpringAngular.cursoSpringAngular.model.repositories.UserRepository;
import br.com.cursoSpringAngular.cursoSpringAngular.rest.exception.UsuarioCadastradoException;

@Service
public class UsuarioService  implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public Usuario cadastrar(Usuario usuario) {
		boolean exist = userRepository.existsByUsername(usuario.getUsername());
		if(exist) {
			throw new UsuarioCadastradoException(usuario.getUsername());
		}
		userRepository.save(usuario);
		return usuario;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));
	return User.builder()
		.username(usuario.getUsername())
		.password(usuario.getPassword())
		.roles("USER")
		.build();
	}

}
