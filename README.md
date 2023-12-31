﻿# Transaction bank

<b>Transaction Bank API</b> é uma aplicação Spring Boot focada em operações bancárias. O projeto foi configurado para rodar no perfil test e possui configurações específicas para otimizar o acesso ao banco de dados, como a desativação da opção open-in-view do JPA.
Atualmente, a API está em desenvolvimento e mais funcionalidades estão sendo adicionadas. A documentação detalhada, gerada pelo Swagger, facilita a compreensão e integração com outros sistemas.

## 📚 Bibliotecas Utilizadas

- **Spring Boot**: Framework para criação de aplicações Java com microserviços.
- **Springdoc OpenAPI**: Biblioteca para geração automática de documentação da API.
- **Spring Boot Starter Data JPA**: Facilita a integração do Spring Boot com o Java Persistence API..
- **Spring Boot Starter Web.**: Biblioteca para desenvolvimento de aplicações web com Spring Boot.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Jakarta Validation API**: API para validação de beans.

## 🚀 Como Iniciar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/Carlos-Landerdahl/transaction-bank.git

2. Navegue até a pasta do projeto:
    ```bash
   cd transaction-bank

3. Execute o projeto usando Maven:
    ```bash
   mvn spring-boot:run

## Documentação
Após seguir os passos acima, a API estará rodando na porta 8080 e a documentação Swagger estará disponível em http://localhost:8080/swagger-ui.html.

## 🤝 Contribuindo
Para contribuir com o projeto, faça um fork do repositório, crie uma nova branch com suas alterações e abra um pull request.
Agradecemos por qualquer contribuição que ajude a melhorar o projeto!
