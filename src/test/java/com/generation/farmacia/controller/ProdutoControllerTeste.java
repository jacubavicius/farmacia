package com.generation.farmacia.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.ProdutoRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProdutoControllerTeste {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoController produtoController;
	
	@BeforeAll
	void start() {

		produtoRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Cadastrar uma categoria")
	public void deveCadastrarUmaProduto() {

		HttpEntity<Produto> corpoRequisicao = new HttpEntity<Produto>(
				new Produto(0L, "Dramin B6", "Mantecorp Farmasa", 18.69f, 200));

		ResponseEntity<Produto> corpoResposta = testRestTemplate.exchange("/produtos", HttpMethod.POST,
				corpoRequisicao, Produto.class);

		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
	}	
	
	@Test
	@DisplayName("Listar todas as categorias")
	public void deveMostrarTodasProdutos() {
		
		produtoController.post(
				new Produto(0L, "Termômetro Digital", "Techline", 17.99f, 130));

		produtoController.post(
				new Produto(0L, "Protetor Solar Facial Toque Seco FPS70", "Nívea", 48.89f, 115));

		ResponseEntity<String> resposta = testRestTemplate.exchange("/produtos/all", HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("Apagar uma categoria")
	public void deveApagarUmaProduto() {

		HttpEntity<Produto> categoriaCadastrada = produtoController.post(
				new Produto(0L, "Amoxicilina 875mg", "EMS", 53.99f, 50));
		
		produtoRepository.deleteById(categoriaCadastrada.getBody().getId());

	}
}

