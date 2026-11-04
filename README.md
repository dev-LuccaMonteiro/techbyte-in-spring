# TECHBYTE IN SPRING

**Desenvolvimento, configuração e testes de uma API REST com Spring Boot e MySQL**
*Repositório: TechByte in Spring – GitHub*[cite: 1]

---

## 1. Introdução

Este documento apresenta detalhadamente o processo de desenvolvimento de uma API REST utilizando Java e Spring Boot, desde a criação inicial do projeto por meio da ferramenta Spring Initializr até a configuração do banco de dados MySQL, criação automática da tabela pelo Hibernate e realização de testes das rotas da API[cite: 1, 3, 4, 5].

O projeto tem como objetivo demonstrar a construção de uma aplicação backend capaz de disponibilizar informações de produtos por meio de requisições HTTP, utilizando tecnologias amplamente empregadas no desenvolvimento de sistemas web[cite: 1].

Durante o desenvolvimento, foram utilizadas ferramentas como Spring Initializr, Maven, Spring Web, Spring Data JPA, Hibernate, MySQL e Postman[cite: 2, 3, 4, 5].

A documentação também apresenta evidências visuais das etapas de desenvolvimento, incluindo a configuração inicial do projeto, os registros de execução da aplicação e os testes realizados no navegador[cite: 1, 2, 3, 4, 5].

---

## 2. Tecnologias utilizadas

Para o desenvolvimento da aplicação, foram utilizadas as seguintes tecnologias:

| Tecnologia | Descrição |
| :--- | :--- |
| **Java 25** | Linguagem utilizada no desenvolvimento backend. |
| **Spring Boot 4.1.2** | Framework responsável pela inicialização e configuração da aplicação.[cite: 4] |
| **Spring Initializr** | Ferramenta utilizada para gerar a estrutura inicial do projeto.[cite: 3, 4] |
| **Maven** | Gerenciador de dependências e ferramenta de build.[cite: 4] |
| **Spring Web** | Responsável pela criação dos endpoints REST.[cite: 4] |
| **Spring Data JPA** | Facilita a comunicação entre a aplicação e o banco de dados.[cite: 4] |
| **Hibernate** | Framework ORM utilizado para mapear entidades Java para tabelas SQL.[cite: 4, 5] |
| **MySQL 8.0.46** | Sistema gerenciador de banco de dados relacional. |
| **MySQL Connector/J** | Driver responsável pela conexão entre Java e MySQL. |
| **Postman** | Ferramenta utilizada para testar as requisições HTTP.[cite: 2] |

---

## 3. Criação do projeto utilizando Spring Initializr

### 3.1. Pesquisa e acesso à ferramenta

O desenvolvimento começou com a pesquisa pela ferramenta oficial Spring Initializr, responsável por gerar a estrutura inicial de projetos utilizando o ecossistema Spring[cite: 3].

Para isso, foi acessado o endereço:
https://start.spring.io/[cite: 3]

O Spring Initializr permite selecionar a linguagem de programação, o sistema de gerenciamento de dependências, a versão do Spring Boot, os metadados do projeto e as bibliotecas necessárias para o desenvolvimento[cite: 4].

![Pesquisa e acesso ao Spring Initializr](https://raw.githubusercontent.com/dev-LuccaMonteiro/techbyte-in-spring/main/assets/01-pesquisa-spring-initialzr.png)
*Figura 1 – Pesquisa e acesso ao Spring Initializr.*[cite: 3]

### 3.2. Configuração inicial do projeto

Após acessar o Spring Initializr, foram definidos os parâmetros necessários para gerar a estrutura da aplicação[cite: 4].

As configurações utilizadas foram[cite: 4]:

| Configuração | Valor |
| :--- | :--- |
| **Project** | Maven |
| **Language** | Java |
| **Spring Boot** | 4.1.2 |
| **Group** | `com.techbyte` |
| **Artifact** | `ecommerce` |
| **Name** | `ecommerce` |
| **Package name** | `com.techbyte.ecommerce` |
| **Packaging** | JAR |
| **Java** | 25 |

O Maven foi escolhido como gerenciador de dependências por facilitar a organização das bibliotecas, a compilação e a execução do projeto[cite: 4].

A linguagem Java foi selecionada por sua utilização no desenvolvimento de aplicações backend e por sua integração com o ecossistema Spring[cite: 4].

![Configuração dos parâmetros do projeto no Spring Initializr](https://raw.githubusercontent.com/dev-LuccaMonteiro/techbyte-in-spring/main/assets/02-configuracao-spring-initialzr.png)
*Figura 2 – Configuração dos parâmetros do projeto no Spring Initializr.*[cite: 4]

### 3.3. Seleção das dependências

Após definir os parâmetros do projeto, foram adicionadas as dependências necessárias para o funcionamento da aplicação[cite: 4].

#### Spring Web
A dependência Spring Web permite desenvolver aplicações web e APIs REST utilizando Spring MVC[cite: 4].
Ela disponibiliza recursos para:
* Criar endpoints HTTP.
* Receber requisições de clientes.
* Retornar respostas em JSON.
* Utilizar o servidor Tomcat embutido[cite: 4].

#### Spring Data JPA
O Spring Data JPA facilita o acesso e a manipulação de dados persistidos em bancos relacionais[cite: 4].
Sua utilização permite trabalhar com entidades Java e operações de persistência sem precisar escrever manualmente todas as consultas SQL.

#### MySQL Driver
O MySQL Driver disponibiliza o conector JDBC necessário para estabelecer a comunicação entre a aplicação Java e o banco de dados MySQL[cite: 4].
Com essa dependência, a aplicação consegue enviar comandos SQL e receber os resultados das operações realizadas no banco.

**Dependências selecionadas:**
* Spring Web[cite: 4]
* Spring Data JPA[cite: 4]
* MySQL Driver[cite: 4]

### 3.4. Geração do projeto

Depois de preencher os metadados e selecionar as dependências, foi utilizada a opção **Generate** do Spring Initializr[cite: 4].

A ferramenta gerou um arquivo compactado contendo a estrutura inicial do projeto, incluindo:
* Arquivo `pom.xml`.
* Diretório `src/main/java`.
* Diretório `src/main/resources`.
* Classe principal da aplicação.
* Estrutura inicial de configuração do Maven.

Após o download, o projeto foi extraído e importado para o ambiente de desenvolvimento.

---

## 4. Importação e organização do projeto

Depois de gerar o projeto, foi realizada sua importação para o ambiente de desenvolvimento.

A estrutura inicial segue a organização convencional de aplicações Spring Boot:

```text
ecommerce/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── techbyte/
│   │   │           └── ecommerce/
│   │   │               └── EcommerceApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── mvnw
├── mvnw.cmd
└── pom.xml
