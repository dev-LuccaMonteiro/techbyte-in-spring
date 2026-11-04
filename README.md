# TechByte in Spring

Documentação detalhada do processo de criação, configuração, inicialização e testes da API REST em Spring Boot.

---

## 1. Pesquisa e Acesso ao Spring Initialzr

O desenvolvimento iniciou-se com a pesquisa do gerador de projetos oficial do ecossistema Spring.

![Pesquisa do Spring Initialzr no Google](assets/01-pesquisa-spring-initialzr.png)
*Figura 1: Pesquisa e acesso ao site oficial do Spring Initialzr.*

---

## 2. Configuração do Projeto no Spring Initialzr

No painel do Spring Initialzr, foram definidos os metadados e as dependências necessárias para a construção do projeto.

![Configuração do projeto no Spring Initialzr](assets/02-configuracao-spring-initialzr.png)
*Figura 2: Definição dos parâmetros do projeto e seleção de dependências.*

### Configurações Selecionadas:
* **Project**: Maven Project
* **Language**: Java
* **Spring Boot**: 4.1.2
* **Group**: `com.techbyte`
* **Artifact**: `ecommerce`
* **Package name**: `com.techbyte.ecommerce`
* **Packaging**: Jar
* **Java**: 25

### Dependências Adicionadas:
* **Spring Web**: Criação de endpoints RESTful e servidor Tomcat embutido.
* **MySQL Driver**: Conector para comunicação com a base de dados MySQL.
* **Spring Data JPA**: Abstração de persistência de dados com Hibernate.

---

## 3. Inicialização e Criação Automática da Tabela

Durante a execução da aplicação, o Hibernate realiza a gestão automática do esquema na base de dados MySQL (`ecomerce`), executando a instrução DDL de criação da tabela.

![Logs da consola demonstrando a criação da tabela](assets/03-logs-criacao-tabela.png)
*Figura 3: Logs da aplicação a confirmar a conexão ao MySQL e a execução da DDL pelo Hibernate.*

### Instrução SQL Gerada:
```sql
create table products (
    id integer not null auto_increment,
    descricao varchar(255),
    nome varchar(255),
    preco float(53) not null,
    primary key (id)
) engine=InnoDB;
