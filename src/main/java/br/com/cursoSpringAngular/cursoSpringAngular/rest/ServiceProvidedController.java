package br.com.cursoSpringAngular.cursoSpringAngular.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.cursoSpringAngular.cursoSpringAngular.model.DTO.ServiceProvidedDTO;
import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Client;
import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.ServiceProvided;
import br.com.cursoSpringAngular.cursoSpringAngular.model.repositories.ClientRepository;
import br.com.cursoSpringAngular.cursoSpringAngular.model.repositories.ServiceProvidedRepository;
import br.com.cursoSpringAngular.cursoSpringAngular.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServiceProvidedController {

	private final ClientRepository clientRepository;
	private final ServiceProvidedRepository serviceProvidedRepository;
	private final BigDecimalConverter bigDecimalConverter;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceProvided salvar(@RequestBody @Valid ServiceProvidedDTO serviceProvidedDTO) {
		LocalDate date =LocalDate.parse(serviceProvidedDTO.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Long clienteId = serviceProvidedDTO.getClient();
		Client client = clientRepository.findById(clienteId)
				.orElseThrow(() ->
				new ResponseStatusException
				(HttpStatus.BAD_REQUEST, "Cliente nao encontrado"));
		
		
		ServiceProvided serviceProvided = new ServiceProvided();
		serviceProvided.setDescription(serviceProvidedDTO.getDescription());
		serviceProvided.setDate(date);
		serviceProvided.setClient(client);
		
		serviceProvided.setPrice(bigDecimalConverter.converter(serviceProvidedDTO.getPrice()));
		return serviceProvidedRepository.save(serviceProvided);
		}
	
	   @GetMapping
	    public List<ServiceProvided> pesquisar(
	            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
	            @RequestParam(value = "mes", required = false) Integer mes
	    ) {
	       	return serviceProvidedRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
	    }
	
}
