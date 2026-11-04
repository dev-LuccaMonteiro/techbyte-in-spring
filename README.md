# TechByte in Spring

Documentação detalhada do processo de criação, configuração, inicialização e testes da API REST em Spring Boot.

---

## 1. Pesquisa e Acesso ao Spring Initialzr

O desenvolvimento iniciou-se com a pesquisa do gerador de projetos oficial do ecossistema Spring.

![Pesquisa do Spring Initialzr no Google](assets/01-pesquisa-spring-initialzr.png)
*Figura 1: Pesquisa e acesso ao site oficial do Spring Initialzr.*[cite: 3]

---

## 2. Configuração do Projeto no Spring Initialzr

No painel do Spring Initialzr, foram definidos os metadados e as dependências necessárias para a construção do projeto.

![Configuração do projeto no Spring Initialzr](assets/02-configuracao-spring-initialzr.png)
*Figura 2: Definição dos parâmetros do projeto e seleção de dependências.*[cite: 4]

### Configurações Selecionadas:
* **Project**: Maven Project[cite: 4]
* **Language**: Java[cite: 4]
* **Spring Boot**: 4.1.2[cite: 4]
* **Group**: `com.techbyte`[cite: 4]
* **Artifact**: `ecommerce`[cite: 4]
* **Package name**: `com.techbyte.ecommerce`[cite: 4]
* **Packaging**: Jar[cite: 4]
* **Java**: 25[cite: 4]

### Dependências Adicionadas:
* **Spring Web**: Criação de endpoints RESTful e servidor Tomcat embutido.[cite: 4]
* **MySQL Driver**: Conector para comunicação com a base de dados MySQL.[cite: 4]
* **Spring Data JPA**: Abstração de persistência de dados com Hibernate.[cite: 4]

---

## 3. Inicialização e Criação Automática da Tabela

Durante a execução da aplicação, o Hibernate realiza a gestão automática do esquema na base de dados MySQL (`ecomerce`), executando a instrução DDL de criação da tabela.

![Logs da consola demonstrando a criação da tabela](assets/03-logs-criacao-tabela.png)
*Figura 3: Logs da aplicação a confirmar a conexão ao MySQL e a execução da DDL pelo Hibernate.*[cite: 5]

### Instrução SQL Gerada:
```sql
create table products (
    id integer not null auto_increment,
    descricao varchar(255),
    nome varchar(255),
    preco float(53) not null,
    primary key (id)
) engine=InnoDB;
```[cite: 5]

---

## 4. Testes dos Endpoints da API

Após a inicialização do serviço na porta `8080`, a rota `/produto` foi validada através de duas ferramentas distintas.

### 4.1. Validação no Navegador
Ao aceder diretamente ao endereço `http://localhost:8080/produto`, o navegador recebe o objeto JSON correspondente.

![Consumo da API pelo navegador](assets/04-teste-navegador.png)
*Figura 4: Resposta JSON exibida diretamente no ecrã do navegador.*[cite: 1]

### 4.2. Validação via Postman
O teste formal da requisição `GET` foi efetuado no Postman, confirmando o estado HTTP 200 OK e a estrutura do payload de resposta.

![Requisição GET no Postman](assets/05-teste-postman.png)
*Figura 5: Execução do pedido GET no Postman com resposta de sucesso em 14 ms.*[cite: 2]

#### Payload Retornado:
```json
{
  "nome": "rtx Shibuya",
  "descricao": "muito potente e feita para codigo",
  "preco": 1000,
  "id": 0
}
```

---

## 5. Instruções para Execução Local

1. Assegurar a instalação do **Java 25** e do serviço **MySQL** ativo na porta `3306`.[cite: 4, 5]
2. Criar a base de dados `ecomerce` no MySQL.[cite: 5]
3. Clonar o repositório:
   ```bash
   git clone [https://github.com/dev-LuccaMonteiro/techbyte-in-spring.git](https://github.com/dev-LuccaMonteiro/techbyte-in-spring.git)
