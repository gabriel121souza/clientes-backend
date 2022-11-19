package br.com.cursoSpringAngular.cursoSpringAngular.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursoSpringAngular.cursoSpringAngular.model.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {

		Optional<Usuario> findByUsername(String username);

		boolean existsByUsername(String username);
}
