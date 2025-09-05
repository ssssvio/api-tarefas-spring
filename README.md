# API de Tarefas - Spring Boot

API REST para gerenciamento de tarefas desenvolvida com Spring Boot para trabalho acadêmico.

## Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Swagger/OpenAPI 3**

##  Configuração do Banco de Dados

A aplicação utiliza PostgreSQL. Configure as credenciais no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tarefas_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Executando a Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/ssssvio/api-tarefas-spring.git
   cd api-tarefas-spring
   ```
2. Configure o banco PostgreSQL:
   - Crie um banco de dados chamado tarefas_db
   - Ajuste as configurações no application.properties

3. Execute a aplicação:
```bash
   mvn spring-boot:run
   ```
4. Acesse a aplicação
 - A API estará disponível em `http://localhost:8080`
 - Swagger UI para documentação e testes em `http://localhost:8080/swagger-ui.html`

## Endpoints Principais
- `GET /api/tarefas` - Listar todas as tarefas
- `GET /api/tarefas/{id}` - Obter tarefa por ID
- `POST /api/tarefas` - Criar nova tarefa
- `PUT /api/tarefas/{id}` - Atualizar tarefa existente
- `DELETE /api/tarefas/{id}` - Deletar tarefa por ID

####  Documentação
A documentação completa da API está disponível através do Swagger UI em: http://localhost:8080/swagger-ui/index.html
#### Autor
Desenvolvido por ssssvio para trabalho acadêmico.