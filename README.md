# Academia Digital 🏋️‍♀️

Projeto desenvolvido com o objetivo de gerenciar uma academia digital, utilizando **Spring Boot** para o backend.
Este projeto foi desenvolvido seguindo a trilha de formação em Java da DIO.

## 📋 Descrição

O sistema **Academia Digital** é uma aplicação para o gerenciamento de academias. Ele permite criar, consultar e excluir matriulas e alunos, além de gerenciar avaliações físicas dos alunos por meio de um cadastro integrado.

A principal funcionalidade do sistema é realizar o controle de:

- Matrículas de Alunos.
- Informações do Aluno (incluindo dados básicos).
- Avaliações físicas associadas aos alunos.

A arquitetura do projeto segue o padrão Spring Boot com camadas bem definidas para entidades, repositórios, serviços e controladores.

## 🛠️ Tecnologias Utilizadas

As principais tecnologias e frameworks utilizados neste projeto são:

- **Java 11**
- **Spring Boot** (Spring Data JPA, Spring MVC)
- **PostgreSQL** (banco de dados)
- **Hibernate** (implementação de JPA)
- **Lombok** (para reduzir boilerplate code)
- **Maven** (gerenciamento de dependências)
- **Postman** (para testes de endpoints REST)

## 🏗️ Arquitetura do Sistema

O projeto utiliza o padrão de arquitetura baseado em camadas:

- **Entidades (Modelos)**: Representam as tabelas e estruturas de dados do banco de dados. Cada entidade é anotada com @Entity e configura atributos como colunas.
- **Repositórios (Repositories)**: Interfaces para acesso aos dados persistidos no banco de dados, utilizando o Spring Data JPA e facilitando a criação de consultas.
- **Serviços (Services)**: Contém a lógica de negócios, responsáveis por implementar as regras como criação, exclusão e modificações nos dados.
- **Controladores (Controllers)**: Disponibilizam endpoints REST para acesso aos recursos do sistema, usando as convenções **HTTP** como **GET**, **POST**, **PUT** e **DELETE**.

## 📦 Dependências e Configuração

Aqui estão algumas dependências essenciais para rodar o projeto:

**Dependências principais no `pom.xml`:**

```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Banco de Dados: PostgreSQL -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

**Configuração do `application.yml`:**
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/academia
    username: seu_usuario
    password: sua_senha
    driver-class-name: org.postgresql.Driver
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: create
      dialect: org.hibernate.dialect.PostgreSQLDialect
```

> Observação: Os dados de usuário e senha devem ser adaptados ao seu ambiente local.

## 🚀 Como Rodar o Projeto

Siga os passos abaixo para executar a aplicação:

1. **Clone o Repositório:**
   ```bash
   git clone https://github.com/miletodev/dio-projeto-academia.git
   cd dio-projeto-academia
   ```

2. **Configure o Banco de Dados:**
    - Certifique-se de que o PostgreSQL esteja instalado e rodando.
    - Crie o banco de dados com o comando:
      ```sql
      CREATE DATABASE academia;
      ```

3. **Configure o Arquivo `application.yml`:**
    - Atualize as credenciais de usuário e senha no arquivo `application.yml` para refletir seu ambiente local.

4. **Execute o Projeto:**
    - Use o seguinte comando:
      ```bash
      ./mvnw spring-boot:run
      ```

5. **Acesse a Aplicação:**
    - Acesse a aplicação por meio do navegador: [http://localhost:8080](http://localhost:8080).

## 📚 Endpoints Disponíveis

Abaixo está uma lista de exemplos dos endpoints disponíveis na aplicação:

- **Alunos**:
    - `POST /alunos`: Cadastrar novo aluno.
    - `GET /alunos`: Listar todos os alunos.
    - `GET /alunos/{id}`: Consultar os detalhes de um aluno específico.

- **Avaliações Físicas**:
    - `POST /avaliacoes/{alunoId}`: Registrar avaliação física para um aluno.
    - `GET /avaliacoes`: Listar todas as avaliações físicas.

> **Nota:** Você pode usar ferramentas como **Postman** ou **Insomnia** para testar os endpoints.

## 🛡️ Boas Práticas Implementadas

- **Separação em camadas** (Controller, Service, Repository);
- **Uso de DTOs** para transferir dados entre camadas;
- **Validação** de campos com anotações do `javax.validation`.

## 🧪 Testes

Atualmente o projeto contém testes baseados em:

- **JUnit 5** para testes unitários.
- **Postman/Insomnia** para testes manuais dos endpoints.

Para executar os testes:
```bash
./mvnw test
```

## 📈 Possíveis Melhorias Futuras

Aqui estão algumas ideias para melhorias futuras:
- Adicionar autenticação e controle de usuários (ex.: Spring Security).
- Implementar testes de integração.
- Melhorar o gerenciamento de erros com mensagens personalizadas.

## 🤝 Contribuições

Contribuições são bem-vindas! Siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma branch (`git checkout -b minha-feature`).
3. Commit suas alterações (`git commit -m 'Minha nova feature'`).
4. Envie um push para a branch (`git push origin minha-feature`).
5. Abra um Pull Request no repositório original.

## 📝 Licença

Este projeto está sob a licença **MIT**. Para mais informações, leia o arquivo [LICENSE](./LICENSE).

---

👨‍💻 Desenvolvido por [Mirtilo Mileto Silva de Almeida](https://github.com/miletodev).