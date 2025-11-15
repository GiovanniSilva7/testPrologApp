Teste Prolog

Este projeto foi desenvolvido como parte de um teste técnico, implementando um sistema de
gestão de veículos, pneus e vinculação entre eles usando **Java 17 + Spring Boot + JPA + PostgreSQL + Flyway**.

O objetivo é manter um cadastro de veículos, cadastro de pneus e uma relação `veiculo_pneu`
permitindo saber qual pneu está em qual posição de um veículo.


 -- Tecnologias Utilizadas -- 
 - Java 17 (Temurin)
- Spring Boot 3.5.7
  - Spring Web  
  - Spring Data JPA  
  - Spring Validation  
  - Spring Boot DevTools  
  - Flyway Migration  
- PostgreSQL 17 (via Docker)
- Docker / Docker Compose
- Lombok
- Maven 3.9+


 -- Estrutura do Projeto -- 
 
 src/
├─ main/
│ ├─ java/com/giovanni/testePrologApp/
│ │ ├─ controller/
│ │ ├─ service/
│ │ ├─ repository/
│ │ ├─ entity/
│ │ ├─ enums/
│ │ └─ TestePrologAppApplication.java
│ └─ resources/
│ ├─ application.properties
│ └─ db/migration/
│ ├─ V1__create_tables.sql
│ └─ V2__alter_tables.sql
└─ test/

 -- yaml -- 
 
 version: '3.1'

services:
  db:
    image: postgres:17
    container_name: test_prolog_db
    restart: always
    environment:
      POSTGRES_DB: test_prolog
      POSTGRES_USER: #####
      POSTGRES_PASSWORD: #####
    ports:
      - "5432:5432"
    volumes:
      - ./data/postgres:/var/lib/postgresql/data
	  
	  
 -- Iniciando Banco (Docker) --

	docker compose up -d
	
 -- Parando banco -- 

	docker compose down
	
 -- Variaveis de ambiente --	
 
 
 TP_APP_NAME=teste_PrologApp
 TP_APP_PORT=8080
 TP_APP_CONTEXT_PATH=/

 TP_DB_URL=jdbc:postgresql://localhost:5432/test_prolog
 TP_DB_USERNAME=#####
 TP_DB_PASSWORD=#####
 TP_DB_DRIVER=org.postgresql.Driver
 
 
  -- Properties --
  
  
  spring.application.name=${TP_APP_NAME}
  server.port=${TP_APP_PORT}
  server.servlet.context-path=${TP_APP_CONTEXT_PATH}

  spring.docker.compose.enabled=false

  spring.datasource.url=${TP_DB_URL}
  spring.datasource.username=${TP_DB_USERNAME}
  spring.datasource.password=${TP_DB_PASSWORD}
  spring.datasource.driver-class-name=${TP_DB_DRIVER}

  spring.jpa.hibernate.ddl-auto=validate
  spring.jpa.show-sql=true

  spring.flyway.enabled=true
  spring.flyway.locations=classpath:db/migration