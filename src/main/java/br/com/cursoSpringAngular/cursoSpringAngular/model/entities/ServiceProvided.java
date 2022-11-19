package br.com.cursoSpringAngular.cursoSpringAngular.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class ServiceProvided{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceId;
	@Column(nullable = false, length = 255)
	private String description;
	@ManyToOne
	private Client client;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

}
