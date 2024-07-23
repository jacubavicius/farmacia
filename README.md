# E-commerce Farmácia
[![Static Badge](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/jacubavicius/farmacia/blob/main/LICENSE)

## Sobre o projeto
O projeto E-commerce Farmácia é uma aplicação desenvolvida com <b>Spring Boot</b> e <b>Java 17</b>, criada como atividade final no bloco 2 no <b>Bootcamp Generation</b>. O objetivo do projeto é aplicar todos os conhecimentos adquiridos ao longo desse bloco. Esta aplicação de e-commerce para uma farmácia inclui funcionalidades de gerenciamento de medicamentos, estoque, vendas e atendimento ao cliente, utilizando os recursos Spring Boot e <b>Data JPA</b>. Além disso, segue o padrão de arquitetura de software <b>MVC</b>.

## Funcionalidades
- Cadastro de produtos e categorias
- Exibição de lista de produtos disponíveis
- Pesquisa por produtos por nome ou categoria
- Edição de dados de produtos cadastradas
- Excluir produtos cadastrado

## Tecnologia utilizada
### Back-End
- Java 17
- Spring Boot
- JPA/Hibernate
- Maven
- Swagger
- JUnit

### Banco de Dados
- MySQL
- H2 (Testes)

## Como executar o projeto
#### Pré-Requisito: Java 17 e MySQL
```bash
# clonar repositório
git clone https://github.com/jacubavicius/farmacia

# entrar na pasta do projeto
cd  farmacia

# configurar o banco de dados MySQL
## acesse o diretório
cd farmacia\src\main\resources

## atualize o arquivo 'application.properties' com username e password
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# construa o projeto com Maven no terminal
mvn clean install

# ainda no terminal, execute
mvn spring-boot:run

```
## Autora

Este projeto foi desenvolvido por <b>Gabriella Jacubavicius</b>

[![linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gabriella-jacubavicius/)
