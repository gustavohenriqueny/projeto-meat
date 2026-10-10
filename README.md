# Meat

Aplicação full stack de estudo (2023): catálogo de restaurantes com cadastro e login de usuários.

## Stack

- **Back-end:** Java 17, Spring Boot 3.1, Spring Security + JWT (jjwt), Spring Data JPA, Liquibase, PostgreSQL
- **Front-end:** Angular 16, PrimeNG, Bootstrap
- **Infra local:** Docker Compose (PostgreSQL)

## Estrutura

```
backend/   API REST (entidades, serviços, filtro JWT, migrations Liquibase)
frontend/  SPA Angular (página inicial, restaurantes, cadastro e login)
```

## Como rodar

```bash
# banco
docker compose -f backend/src/main/resources/docker/docker-compose.yml up -d

# back-end
cd backend && ./mvnw spring-boot:run

# front-end
cd frontend && npm install && npm start
```

> ⚠️ As credenciais do banco e a chave JWT em `application.yml` são **apenas para ambiente local** e não são usadas em nenhum ambiente real. Em produção, use variáveis de ambiente ou um cofre de segredos.

Projeto arquivado — mantido como registro de estudo.
