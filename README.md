# TechByte in Spring

Este repositório contém o passo a passo completo da construção e teste de uma API REST desenvolvida em Java utilizando Spring Boot, Spring Data JPA, Hibernate e MySQL.

## Índice

* [1. Configuração do Projeto (Spring Initialzr)](#1-configuração-do-projeto-spring-initialzr)
* [2. Estrutura e Dependências](#2-estrutura-e-dependências)
* [3. Mapeamento e Persistência no Banco de Dados](#3-mapeamento-e-persistência-no-banco-de-dados)
* [4. Testando os Endpoints da API](#4-testando-os-endpoints-da-api)
  * [Navegador](#navegador)
  * [Postman](#postman)
* [5. Como Executar o Projeto](#5-como-executar-o-projeto)

## 1. Configuração do Projeto (Spring Initialzr)

O projeto foi inicializado através da ferramenta oficial [Spring Initialzr](https://start.spring.io/) com as seguintes especificações:

| Parâmetro | Valor Configurado |
| --- | --- |
| **Project** | Maven |
| **Language** | Java |
| **Spring Boot** | 4.1.2 |
| **Group** | `com.techbyte` |
| **Artifact** | `ecommerce` |
| **Package name** | `com.techbyte.ecommerce` |
| **Packaging** | Jar |
| **Java** | 25 |

## 2. Estrutura e Dependências

As principais dependências adicionadas ao projeto foram:

* **Spring Web**: Responsável por fornecer suporte à criação de APIs RESTful e servidor Tomcat embutido.
* **Spring Data JPA**: Fornece suporte ao padrão ORM (Object-Relational Mapping) facilitando a integração com o banco de dados via Hibernate.
* **MySQL Driver**: Conector JDBC para comunicação da aplicação com o banco de dados MySQL.

## 3. Mapeamento e Persistência no Banco de Dados

A aplicação conecta-se ao banco de dados MySQL (`ecomerce`) rodando na porta `3306`. Durante a inicialização da aplicação, o Hibernate gera automaticamente a tabela `products` a partir da entidade configurada:

```sql
create table products (
    id integer not null auto_increment,
    descricao varchar(255),
    nome varchar(255),
    preco float(53) not null,
    primary key (id)
) engine=InnoDB;
```

## 4. Testando os Endpoints da API

A rota principal disponibilizada é a `/produto`, acessível via método `GET`.

### Navegador

Acessando a URL `http://localhost:8080/produto` diretamente pelo navegador, é retornada a representação do objeto em formato JSON:

```json
{
  "nome": "rtx Shibuya",
  "descricao": "muito potente e feita para codigo",
  "preco": 1000,
  "id": 0
}
```

### Postman

Para validação de desempenho e resposta HTTP, a requisição `GET` foi executada via Postman:

* **URL**: `http://localhost:8080/produto`
* **Método**: `GET`
* **Status Code**: `200 OK`
* **Tempo de Resposta**: `~14 ms`
* **Corpo da Resposta (JSON)**:

```json
{
  "nome": "rtx Shibuya",
  "descricao": "muito potente e feita para codigo",
  "preco": 1000,
  "id": 0
}
```

## 5. Como Executar o Projeto

### Pré-requisitos

* **Java JDK 25** instalado.
* Servidor **MySQL** em execução localmente na porta `3306` com o schema `ecomerce` criado.

### Passos

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/dev-LuccaMonteiro/techbyte-in-spring.git
   ```

2. **Entrar no diretório do projeto:**
   ```bash
   cd techbyte-in-spring
   ```

3. **Configurar as credenciais do banco:**
   Verifique o arquivo `src/main/resources/application.properties` para garantir que o usuário e a senha do MySQL correspondem à sua máquina:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ecomerce
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Executar a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Acessar o endpoint:**
   Abra no navegador ou client de API (Postman/Insomnia):
   `http://localhost:8080/produto`