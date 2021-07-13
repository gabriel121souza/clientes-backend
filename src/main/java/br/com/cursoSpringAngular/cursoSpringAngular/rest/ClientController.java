package br.com.cursoSpringAngular.cursoSpringAngular.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Client;
import br.com.cursoSpringAngular.cursoSpringAngular.model.repositories.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@RequestBody @Valid Client client) {
		return repository.save(client);
	}
	
	@GetMapping("{id}")
	public Client findById(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		repository.findById(id)
		.map(client -> {
			repository.delete(client);
			return Void.TYPE;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody @Valid Client updatedClient) {
		repository.findById(id)
		.map( client -> {
			//faz o update completo 
			//updatedClient.setClientId(client.getClientId());
			client.setName(updatedClient.getName());
			client.setCpf(updatedClient.getCpf());
			return repository.save(updatedClient);
			
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		
	}
	
}
