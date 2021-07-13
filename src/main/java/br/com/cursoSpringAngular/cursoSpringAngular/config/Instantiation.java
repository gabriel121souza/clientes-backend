package br.com.cursoSpringAngular.cursoSpringAngular.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Client;
import br.com.cursoSpringAngular.cursoSpringAngular.model.repositories.ClientRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired 
	private ClientRepository ClientRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
			//criando um objeto com o builder
			Client client = Client.builder().name("Gabriel").cpf("06398566165").build();
			 ClientRepository.save(client);
			
	}
	
}
