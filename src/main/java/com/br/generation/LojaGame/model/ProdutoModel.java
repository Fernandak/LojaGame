package com.br.generation.LojaGame.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 4, max = 255)
	private String nome;
	
	@NotBlank
	@Size(min = 4, max = 550)
	private String descricao;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;
	
	

}
