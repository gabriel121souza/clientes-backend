package br.com.cursoSpringAngular.cursoSpringAngular.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
