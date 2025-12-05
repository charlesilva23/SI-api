# si-api

Uma API RESTful desenvolvida com Spring Boot para gerenciar tickets e seus status.

## Visão Geral

Este projeto implementa uma API RESTful para um sistema de gestão, utilizando Spring Boot e Java 21. Ele fornece endpoints para manipulação de tickets, com persistência de dados no PostgreSQL e integração de funcionalidades comuns como validação de dados e configuração de CORS.

## Tecnologias

As principais tecnologias utilizadas neste projeto são:

*   **Java 21**
*   **Spring Boot 3.5.0**
*   **Maven**
*   **Spring Data JPA**
*   **PostgreSQL**
*   **Lombok**
*   **Spring Validation**
*   **Docker Compose**

## Configuração do Ambiente de Desenvolvimento

Para configurar e rodar o projeto localmente, siga os passos abaixo.

### Pré-requisitos

Certifique-se de ter instalado:

*   **Java Development Kit (JDK) 21**
*   **Maven** (geralmente incluído no Spring Boot CLI ou pode ser instalado separadamente)
*   **Docker** e **Docker Compose**

### Banco de Dados (PostgreSQL)

O banco de dados PostgreSQL é gerenciado via Docker Compose.

1.  **Navegue até a raiz do projeto:**
    ```bash
    cd /caminho/para/o/seu/projeto/si-api
    ```
2.  **Inicie o contêiner do PostgreSQL:**
    ```bash
    docker-compose up -d postgres
    ```
    Isso iniciará um servidor PostgreSQL na porta `5432` com o banco de dados `sidb`, usuário `siuser` e senha `sipassword`.

### Configuração da Aplicação

As configurações do banco de dados e outros detalhes podem ser encontrados em `src/main/resources/application.properties`. As credenciais e URL do banco de dados já estão configuradas para o ambiente Docker Compose.

A aplicação também está configurada para permitir requisições CORS de `http://localhost:3000`, facilitando a integração com um frontend em desenvolvimento.

## Como Construir e Rodar a Aplicação

1.  **Construa o projeto usando Maven:**
    ```bash
    ./mvnw clean install
    ```
    Este comando compilará o código e empacotará a aplicação.

2.  **Execute a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080/api/v1`.

## Executando os Testes

Para executar os testes automatizados do projeto:

```bash
./mvnw test
```

## Exemplo de Endpoints

A API expõe endpoints sob o caminho `/api/v1`. Por exemplo, para recursos de ticket, você pode ter:

*   `GET /api/v1/tickets`: Obter todos os tickets.
*   `POST /api/v1/tickets`: Criar um novo ticket.
*   `GET /api/v1/tickets/{id}`: Obter um ticket específico por ID.
*   `PUT /api/v1/tickets/{id}`: Atualizar um ticket existente.
*   `DELETE /api/v1/tickets/{id}`: Excluir um ticket.

Desenvolvido com ❤️
