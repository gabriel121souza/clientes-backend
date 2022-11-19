package br.com.cursoSpringAngular.cursoSpringAngular.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.ServiceProvided;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Long> {
	 

    @Query(" select s from ServiceProvided s join s.client c " +
            " where upper( c.name ) like upper( :nome ) and MONTH(s.date) =:mes    ")
    List<ServiceProvided> findByNomeClienteAndMes(
            @Param("nome") String nome, @Param("mes") Integer mes);
}
