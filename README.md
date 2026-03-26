### 🚀 Core Mopo Service
API estruturada com **boas práticas de desenvolvimento** e preparada para ambientes de **desenvolvimento e produção**.

### 📌 Descrição
Esta aplicação segue boas práticas de arquitetura, com separação clara de responsabilidades entre camadas e serviços.

O objetivo é fornecer uma base escalável, organizada e pronta para evolução, com suporte a monitoramento e configuração por ambiente.
### 📊 [Diagramas](./DIAGRAMS.md)

### 🏛️ Arquitetura 
O sistema segue uma arquitetura de **Microsserviços**:

**Recipes Service** Responsável pelas receitas. Funcionalidades:
- Cadastro de receitas
- Ingredientes e instruções
- Avaliação e dificuldade
 
<!--
 ### 🧪 Estratégia de Testes

A qualidade é garantida através da Pirâmide de Testes, cobrindo **>83%** do código no Core Banking:

| Tipo                       | Ferramentas      | O que testamos?                                                                   |
| :------------------------- | :--------------- | :-------------------------------------------------------------------------------- |
| **Unitários**              | JUnit 5, Mockito | Lógica de Domínio (`Wallet`), Casos de Uso e Services.                            |
| **Slice (Web)**            | `@WebMvcTest`    | Contrato da API, Serialização JSON e Tratamento de Exceções Global.               |
| **Integração (DB)**        | Testcontainers   | Cenários de concorrência real no PostgreSQL (Double Spending).                    |
| **Integração (Messaging)** | Testcontainers   | Publicação e consumo de mensagens no RabbitMQ com validação de ACK/NACK.          |
| **Integração (HTTP)**      | WireMock         | Simulação de falhas e timeouts do serviço externo para validar o Circuit Breaker. |
| **BDD**                    | AssertJ          | Testes descritivos e legíveis focados em comportamento.                           | --> |
### 🚀 Como rodar em modo dev e prod
```bash
docker compose -f docker-compose.yaml -f docker-compose.dev.yaml up --build
```

```bash
docker compose -f docker-compose.yaml -f docker-compose.prod.yaml up --build
```

### ⚙️ Tech Stack
- Language: Java 21 +  + JPA + Lombok
- Framework: Spring Boot 3 (Web, Data JPA, Validation, Actuator, Lombok)
- Database: PostgreSQL (produção) e H2 (desenvolvimento)  
- Containerização: Docker e Docker Compose
- Observabilidade: Prometheus e Grafana
- Documentação: Swagger / OpenAPI  