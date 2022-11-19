package br.com.cursoSpringAngular.cursoSpringAngular.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.cursoSpringAngular.cursoSpringAngular.clientes.services.UsuarioService;
import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Usuario;
import br.com.cursoSpringAngular.cursoSpringAngular.rest.exception.UsuarioCadastradoException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {
	@Autowired
	private final UsuarioService usuarioService;
	
	@PostMapping("/criar-usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public void salva(@RequestBody @Valid  Usuario user) {
		try{usuarioService.cadastrar(user);
		}catch(UsuarioCadastradoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
