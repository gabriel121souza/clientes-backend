package br.com.cursoSpringAngular.cursoSpringAngular.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, name = "username")
	@NotEmpty(message = "{campo.username.obrigatorio}")
	private String username;
	@NotEmpty(message = "{campo.username.obrigatorio}")
	@Column(name="password")
	private String password;
}
