package com.generation.farmacia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo 'categoria' é obrigatório!")
	@Size(min = 5, max = 50, message = "O campo 'categoria' deve ter no mínimo 5 e no máxico 50 caracteres")
	private String categoria;
	
	@NotBlank(message = "O campo 'subCategoria' é obrigatório!")
	@Size(min = 5, max = 50, message = "O campo 'subCategoria' deve ter no mínimo 5 e no máxico 50 caracteres")
	private String subCategoria;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}
}
