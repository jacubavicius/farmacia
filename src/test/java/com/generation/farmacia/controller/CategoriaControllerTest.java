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

import com.generation.farmacia.model.Categoria;
import com.generation.farmacia.repository.CategoriaRepository;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoriaControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CategoriaController categoriaController;
	
	@BeforeAll
	void start() {

		categoriaRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Cadastrar uma categoria")
	public void deveCadastrarUmaCategoria() {

		HttpEntity<Categoria> corpoRequisicao = new HttpEntity<Categoria>(
				new Categoria(0L, "Medicamentos", "Antibióticos"));

		ResponseEntity<Categoria> corpoResposta = testRestTemplate.exchange("/categorias", HttpMethod.POST,
				corpoRequisicao, Categoria.class);

		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
	}	
	
	@Test
	@DisplayName("Listar todas as categorias")
	public void deveMostrarTodasCategorias() {
		
		categoriaController.post(
				new Categoria(0L, "Cuidados com os Olhos", "Colírios"));

		categoriaController.post(
				new Categoria(0L, "Cuidados Pessoais", "Higiene Pessoal"));

		ResponseEntity<String> resposta = testRestTemplate.exchange("/categorias/all", HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("Apagar uma categoria")
	public void deveApagarUmaCategoria() {

		HttpEntity<Categoria> categoriaCadastrada = categoriaController.post(
				new Categoria(0L, "Cuidados Pessoais", "Higiene Pessoal"));
		
		categoriaRepository.deleteById(categoriaCadastrada.getBody().getId());

	}
}
