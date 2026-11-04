# TECHBYTE IN SPRING

**Desenvolvimento, configuração e testes de uma API REST com Spring Boot e MySQL**
*Repositório: TechByte in Spring – GitHub*

---

## 1. Introdução

Este documento apresenta detalhadamente o processo de desenvolvimento de uma API REST utilizando Java e Spring Boot, desde a criação inicial do projeto por meio da ferramenta Spring Initializr até a configuração do banco de dados MySQL, criação automática da tabela pelo Hibernate e realização de testes das rotas da API.

O projeto tem como objetivo demonstrar a construção de uma aplicação backend capaz de disponibilizar informações de produtos por meio de requisições HTTP, utilizando tecnologias amplamente empregadas no desenvolvimento de sistemas web.

Durante o desenvolvimento, foram utilizadas ferramentas como Spring Initializr, Maven, Spring Web, Spring Data JPA, Hibernate, MySQL e Postman.

A documentação também apresenta evidências visuais das etapas de desenvolvimento, incluindo a configuração inicial do projeto, os registros de execução da aplicação e os testes realizados no navegador e no Postman.

---

## 2. Tecnologias utilizadas

Para o desenvolvimento da aplicação, foram utilizadas as seguintes tecnologias:

| Tecnologia | Descrição |
| :--- | :--- |
| **Java 25** | Linguagem utilizada no desenvolvimento backend. |
| **Spring Boot 4.1.2** | Framework responsável pela inicialização e configuração da aplicação. |
| **Spring Initializr** | Ferramenta utilizada para gerar a estrutura inicial do projeto. |
| **Maven** | Gerenciador de dependências e ferramenta de build. |
| **Spring Web** | Responsável pela criação dos endpoints REST. |
| **Spring Data JPA** | Facilita a comunicação entre a aplicação e o banco de dados. |
| **Hibernate** | Framework ORM utilizado para mapear entidades Java para tabelas SQL. |
| **MySQL 8.0.46** | Sistema gerenciador de banco de dados relacional. |
| **MySQL Connector/J** | Driver responsável pela conexão entre Java e MySQL. |
| **Postman** | Ferramenta utilizada para testar as requisições HTTP. |

---

## 3. Criação do projeto utilizando Spring Initializr

### 3.1. Pesquisa e acesso à ferramenta

O desenvolvimento começou com a pesquisa pela ferramenta oficial Spring Initializr, responsável por gerar a estrutura inicial de projetos utilizando o ecossistema Spring.

Para isso, foi acessado o endereço:
https://start.spring.io/

O Spring Initializr permite selecionar a linguagem de programação, o sistema de gerenciamento de dependências, a versão do Spring Boot, os metadados do projeto e as bibliotecas necessárias para o desenvolvimento.

![Pesquisa e acesso ao Spring Initializr](https://raw.githubusercontent.com/dev-LuccaMonteiro/techbyte-in-spring/main/assets/01-pesquisa-spring-initialzr.png)
*Figura 1 – Pesquisa e acesso ao Spring Initializr.*

### 3.2. Configuração inicial do projeto

Após acessar o Spring Initializr, foram definidos os parâmetros necessários para gerar a estrutura da aplicação.

As configurações utilizadas foram:

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

O Maven foi escolhido como gerenciador de dependências por facilitar a organização das bibliotecas, a compilação e a execução do projeto.

A linguagem Java foi selecionada por sua utilização no desenvolvimento de aplicações backend e por sua integração com o ecossistema Spring.

![Configuração dos parâmetros do projeto no Spring Initializr](https://raw.githubusercontent.com/dev-LuccaMonteiro/techbyte-in-spring/main/assets/02-configuracao-spring-initialzr.png)
*Figura 2 – Configuração dos parâmetros do projeto no Spring Initializr.*

### 3.3. Seleção das dependências

Após definir os parâmetros do projeto, foram adicionadas as dependências necessárias para o funcionamento da aplicação.

#### Spring Web
A dependência Spring Web permite desenvolver aplicações web e APIs REST utilizando Spring MVC.
Ela disponibiliza recursos para:
* Criar endpoints HTTP.
* Receber requisições de clientes.
* Retornar respostas em JSON.
* Utilizar o servidor Tomcat embutido.

#### Spring Data JPA
O Spring Data JPA facilita o acesso e a manipulação de dados persistidos em bancos relacionais.
Sua utilização permite trabalhar com entidades Java e operações de persistência sem precisar escrever manualmente todas as consultas SQL.

#### MySQL Driver
O MySQL Driver disponibiliza o conector JDBC necessário para estabelecer a comunicação entre a aplicação Java e o banco de dados MySQL.
Com essa dependência, a aplicação consegue enviar comandos SQL e receber os resultados das operações realizadas no banco.

**Dependências selecionadas:**
* Spring Web
* Spring Data JPA
* MySQL Driver

### 3.4. Geração do projeto

Depois de preencher os metadados e selecionar as dependências, foi utilizada a opção **Generate** do Spring Initializr.

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
```

O arquivo `pom.xml` contém as dependências e configurações necessárias para o Maven gerenciar o projeto.
A classe principal é responsável por iniciar a aplicação Spring Boot.

---

## 5. Configuração do banco de dados MySQL

### 5.1. Criação do banco de dados

Para permitir que a aplicação armazene e consulte informações dos produtos, foi utilizado o MySQL como sistema gerenciador de banco de dados.

Nesta configuração, o banco de dados utilizado será denominado `produto_ti`.

Inicialmente, é necessário acessar o MySQL por uma ferramenta como MySQL Workbench ou pelo terminal. Em seguida, executar:

```sql
CREATE DATABASE produto_ti;
```

Para selecionar o banco criado:

```sql
USE produto_ti;
```

Essa etapa prepara o banco de dados que será utilizado pela aplicação Spring Boot.

> **Importante**: O README original do repositório registra o nome `ecomerce`. A utilização de `produto_ti` representa uma alteração de configuração em relação à documentação original.

### 5.2. Configuração da conexão

Para estabelecer a comunicação entre Spring Boot e MySQL, é necessário configurar o arquivo `application.properties`.

Exemplo de configuração:

```properties
spring.application.name=ecommerce

spring.datasource.url=jdbc:mysql://localhost:3306/produto_ti
spring.datasource.username=root
spring.datasource.password=SUA_SENHA

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

**Descrição das configurações:**
* `spring.datasource.url`: Endereço de conexão com o banco de dados.
* `spring.datasource.username`: Usuário utilizado para acessar o MySQL.
* `spring.datasource.password`: Senha do usuário do banco.
* `spring.datasource.driver-class-name`: Driver JDBC do MySQL.
* `spring.jpa.hibernate.ddl-auto`: Define como o Hibernate administra a estrutura das tabelas.
* `spring.jpa.show-sql`: Permite visualizar os comandos SQL executados.
* `hibernate.dialect`: Informa o dialeto SQL utilizado pelo Hibernate.

A propriedade `ddl-auto=update` permite que o Hibernate atualize a estrutura do banco conforme o mapeamento das entidades JPA.
A senha deve ser substituída pela credencial local do MySQL e não deve ser publicada no repositório.

---

## 6. Criação automática da tabela utilizando Hibernate

### 6.1. Funcionamento do Hibernate

Após configurar a conexão com o MySQL, a aplicação utiliza o Hibernate para realizar o mapeamento objeto-relacional.
Esse mecanismo permite representar registros do banco de dados por meio de classes Java.

Quando a aplicação é inicializada, o Hibernate verifica as entidades mapeadas e, de acordo com a configuração de geração do esquema, executa os comandos SQL necessários.

No projeto, foi identificada a criação de uma tabela denominada `products`.
A estrutura registrada no log de execução é:

```sql
CREATE TABLE products (
    id INTEGER NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255),
    nome VARCHAR(255),
    preco FLOAT(53) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;
```

A tabela possui os seguintes campos:

| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| **id** | `INTEGER` | Identificador único do produto. |
| **descricao** | `VARCHAR(255)` | Descrição do produto. |
| **nome** | `VARCHAR(255)` | Nome do produto. |
| **preco** | `FLOAT` | Valor do produto. |

O campo `id` possui incremento automático, permitindo que o banco gere um identificador para cada registro inserido.

![Log de execução demonstrando a conexão com MySQL e a criação da tabela pelo Hibernate](https://raw.githubusercontent.com/dev-LuccaMonteiro/techbyte-in-spring/main/assets/03-logs-criacao-tabela.png)
*Figura 3 – Log de execução demonstrando a conexão com MySQL e a criação da tabela pelo Hibernate.*

### 6.2. Verificação da tabela no MySQL

Após iniciar a aplicação, é possível verificar se a tabela foi criada corretamente.

Para isso, executar:

```sql
USE produto_ti;

SHOW TABLES;
```

Para consultar a estrutura da tabela:

```sql
DESCRIBE products;
```

Para consultar os registros armazenados:

```sql
SELECT * FROM products;
```

Dessa maneira, é possível verificar se o Hibernate realizou corretamente o mapeamento entre a entidade Java e a estrutura relacional do MySQL.

---

## 7. Inicialização da aplicação Spring Boot

Após configurar o banco de dados, a aplicação pode ser iniciada utilizando o Maven.

No terminal, dentro da pasta do projeto, executar:

```bash
mvn spring-boot:run
```

Durante a inicialização, o Spring Boot realiza diferentes etapas:
1. Carrega as configurações da aplicação.
2. Inicializa o servidor Tomcat.
3. Estabelece a conexão com o banco de dados MySQL.
4. Inicializa o Hibernate.
5. Verifica e administra a estrutura das tabelas.
6. Disponibiliza os endpoints HTTP.

No log apresentado durante a execução, foi possível identificar:

```text
Database driver: MySQL Connector/J
Database version: 8.0.46
Database dialect: MySQLDialect
Default catalog/schema: ecomerce
```

Também foi identificada a execução do comando de criação da tabela `products`.
Esses registros demonstram a inicialização dos componentes de persistência e a comunicação com o banco de dados.

> **Observação**: O log original apresenta o schema `ecomerce`. Para utilizar `produto_ti`, é necessário atualizar a URL de conexão no `application.properties` e reiniciar a aplicação.

---

## 8. Testes das rotas da API

Após a inicialização do servidor, foram realizados testes para verificar o funcionamento da API REST.

A aplicação disponibiliza a rota:

```http
GET http://localhost:8080/produto
```

Essa rota permite acessar as informações de produto disponibilizadas pela aplicação.

### 8.1. Teste pelo navegador

Para realizar o primeiro teste, foi utilizado um navegador web.
Com a aplicação em execução, foi digitado o endereço:

`http://localhost:8080/produto`

O navegador realizou uma requisição HTTP GET ao servidor Spring Boot.
A aplicação processou a requisição e retornou os dados do produto no formato JSON.

![Consumo da API REST diretamente pelo navegador](https://raw.githubusercontent.com/dev-LuccaMonteiro/techbyte-in-spring/main/assets/04-teste-navegador.png)
*Figura 4 – Consumo da API REST diretamente pelo navegador.*

O retorno registrado no projeto foi:

```json
{
    "nome": "rtx Shibuya",
    "descricao": "muito potente e feita para codigo",
    "preco": 1000,
    "id": 0
}
```

Esse teste demonstra que o endpoint conseguiu responder a uma requisição HTTP e disponibilizar os dados em formato JSON.

### 8.2. Teste utilizando Postman

Além do navegador, foi utilizada a ferramenta Postman para validar o endpoint.
O Postman permite configurar requisições HTTP e analisar os resultados retornados pela API.

**Passos realizados:**
1. Abrir o Postman.
2. Criar uma nova requisição.
3. Selecionar o método HTTP GET.
4. Informar o endereço `http://localhost:8080/produto`.
5. Clicar em Send.
6. Verificar o código de resposta e o conteúdo JSON.

![Teste da rota GET utilizando Postman](https://raw.githubusercontent.com/dev-LuccaMonteiro/techbyte-in-spring/main/assets/05-teste-postman.png)
*Figura 5 – Teste da rota GET utilizando Postman.*

O resultado documentado foi:

| Informação | Resultado |
| :--- | :--- |
| **Método HTTP** | `GET` |
| **Endpoint** | `/produto` |
| **Status HTTP** | `200 OK` |
| **Tempo informado** | `14 ms` |
| **Formato da resposta** | `JSON` |

O código HTTP `200 OK` indica que a requisição foi processada com sucesso.

---

## 9. Análise dos resultados

Com base nos testes e nos registros de execução, foi possível observar que a aplicação conseguiu inicializar o ambiente Spring Boot e estabelecer comunicação com o MySQL.

A utilização do Hibernate permitiu gerar automaticamente a estrutura da tabela `products`, reduzindo a necessidade de criação manual da estrutura SQL.

Os testes realizados pelo navegador e pelo Postman demonstraram que o endpoint `/produto` conseguiu retornar informações em formato JSON.

**Resumo das etapas comprovadas:**
* Configuração inicial do projeto com Spring Initializr.
* Integração das dependências Spring Web, Spring Data JPA e MySQL Driver.
* Configuração de conexão com o banco de dados.
* Inicialização do Hibernate.
* Criação automática da tabela `products`.
* Disponibilização de uma rota HTTP.
* Consumo da API pelo navegador.
* Validação da resposta utilizando Postman.

---

## 10. Possíveis melhorias

Apesar de demonstrar os principais conceitos de criação e consumo de uma API REST, o projeto pode evoluir com a implementação de novas funcionalidades.

Entre as melhorias possíveis estão:
* Implementar operações CRUD completas (cadastrar, consultar, atualizar e excluir produtos).
* Organizar o código em camadas (`Controller`, `Service` e `Repository`).
* Implementar validações com Bean Validation.
* Utilizar `BigDecimal` para representar valores monetários.
* Criar testes automatizados com JUnit e Mockito.
* Implementar tratamento global de exceções.
* Criar documentação dos endpoints utilizando Swagger / OpenAPI.
* Adicionar variáveis de ambiente para proteger as credenciais do banco de dados.

Essas melhorias podem tornar a aplicação mais organizada, segura e preparada para utilização em ambientes de produção.

---

## 11. Conclusão

O desenvolvimento do projeto **TechByte in Spring** permitiu aplicar conceitos fundamentais de desenvolvimento backend utilizando Java e Spring Boot.

Desde a criação do projeto no Spring Initializr até os testes realizados no navegador e no Postman, foi possível compreender o funcionamento da estrutura de uma aplicação REST e sua integração com um banco de dados relacional.

A utilização do Spring Data JPA e do Hibernate demonstrou como o mapeamento objeto-relacional facilita a comunicação entre classes Java e tabelas SQL, permitindo inclusive a criação automática da estrutura do banco de dados.

Os testes realizados demonstraram o funcionamento do endpoint `/produto`, que disponibilizou informações no formato JSON por meio de uma requisição HTTP GET.

Portanto, o projeto representa uma experiência prática importante para compreender os fundamentos do desenvolvimento de APIs REST com Java, Spring Boot e MySQL, servindo como base para a construção de aplicações backend mais completas.

---

## 12. Referências

* Repositório TechByte in Spring – GitHub
* Spring Initializr
* Documentação oficial Spring Boot
* Documentação Spring Data JPA
* Documentação oficial MySQL

---

**Resumo das Especificações do Projeto:**
* **Projeto**: TechByte in Spring
* **Linguagem**: Java
* **Framework**: Spring Boot
* **Banco de dados**: MySQL
* **Tipo de aplicação**: API REST
