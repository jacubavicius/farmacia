package com.generation.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo 'descrição' é obrigatório!")
	@Size(min = 5, max = 50, message = "O campo 'descrição' deve ter no mínimo 5 e no máxico 50 caracteres")
	private String nome;
	
	@NotBlank(message = "O campo 'marca' é obrigatório!")
	@Size(max = 50, message = "O campo 'marca' deve ter no mmáxico 50 caracteres")
	private String marca;
	
	@NotNull
	private float preco;
	
	@NotNull
	private int quantidade;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	
	public Produto(Long id, String nome, String marca, float preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Produto() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
