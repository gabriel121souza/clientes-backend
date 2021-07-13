package br.com.cursoSpringAngular.cursoSpringAngular.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
