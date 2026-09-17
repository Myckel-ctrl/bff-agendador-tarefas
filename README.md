# BFF Agendador de Tarefas — Microsserviço

BFF (Backend for Frontend) desenvolvido com **Java e Spring Boot**, responsável por centralizar as requisições do cliente e realizar a comunicação com os microsserviços de **Usuário** e **Agendador de Tarefas**.

O projeto atua como uma camada intermediária entre o cliente e os microsserviços, simplificando o acesso às funcionalidades da aplicação e realizando a comunicação através do **OpenFeign**.

---

## 🏗️ Arquitetura

```text
                  Cliente
                     │
                     ▼
             ┌───────────────┐
             │      BFF      │
             │ Spring Boot   │
             │    :8083      │
             └───────┬───────┘
                     │
              ┌──────┴──────┐
              │             │
              ▼             ▼
      ┌──────────────┐  ┌──────────────────┐
      │   Usuário    │  │ Agendador de     │
      │    :8080     │  │     Tarefas      │
      │              │  │      :8081       │
      └──────────────┘  └──────────────────┘
```

O fluxo principal da aplicação é:

```text
Cliente
   ↓
Controller
   ↓
Service
   ↓
Feign Client
   ↓
Microsserviço
```

O BFF **não possui banco de dados próprio**. Ele atua como uma camada de comunicação entre o cliente e os microsserviços.

---

## 🚀 Tecnologias

* Java 21
* Spring Boot
* Spring Web
* Spring Security
* JWT
* Spring Cloud OpenFeign
* Spring Validation
* Lombok
* Swagger / OpenAPI
* Gradle
* Git / GitHub

---

## 🔐 Autenticação

A aplicação utiliza **JWT (JSON Web Token)** para autenticação.

O token recebido pelo BFF é encaminhado automaticamente aos microsserviços através de um `RequestInterceptor` do OpenFeign.

```text
Cliente
   │
   │ Authorization: Bearer <token>
   ▼
  BFF
   │
   │ Authorization: Bearer <token>
   ▼
Microsserviço
```

Dessa forma, o BFF não precisa realizar uma nova autenticação do usuário para cada requisição.

---

## 🔄 Comunicação entre os microsserviços

A comunicação entre o BFF e os microsserviços é realizada através do **OpenFeign**.

O BFF possui clientes responsáveis por cada microsserviço:

```text
UsuarioClient
      ↓
Microsserviço Usuário

TarefaClient
      ↓
Microsserviço Agendador de Tarefas
```

O BFF também possui tratamento de erros das chamadas realizadas através do Feign, permitindo transformar respostas de erro dos microsserviços em exceções tratadas pela aplicação.

---

## 📌 Funcionalidades

### Usuários

* Cadastro de usuário
* Login
* Consulta dos dados do usuário autenticado
* Atualização dos dados do usuário
* Exclusão do usuário

### Endereços

* Cadastro de endereço
* Atualização de endereço
* Exclusão de endereço

### Telefones

* Cadastro de telefone
* Atualização de telefone
* Exclusão de telefone

### Tarefas

* Criar tarefa
* Buscar tarefa por ID
* Listar tarefas
* Buscar tarefas por período
* Atualizar tarefa
* Atualizar status da tarefa
* Excluir tarefa

---

## 📚 Documentação da API

A API possui documentação através do **Swagger/OpenAPI**.

Após iniciar o BFF, a documentação pode ser acessada em:

```text
http://localhost:8083/swagger-ui.html
```

---

## ⚙️ Configuração

O projeto utiliza `application.properties` para configurar a aplicação e as URLs dos microsserviços.

Exemplo:

```properties
server.port=8083

spring.application.name=bff-agendador-tarefas

usuario.url=http://localhost:8080
agendador-tarefas.url=http://localhost:8081
```

As URLs devem corresponder às portas utilizadas pelos respectivos microsserviços.

---

## ▶️ Execução

Para executar o sistema corretamente, é necessário que **os três projetos estejam em execução simultaneamente**:

1. `usuario`
2. `agendador-tarefas`
3. `bff-agendador-tarefas`

### 1. Microsserviço Usuário

Clone o repositório:

```bash
git clone https://github.com/Myckel-ctrl/usuario.git
```

Crie um `Database` chamado `user_db` no Postgres e edite o arquivo `application.yml` com suas credenciais do PostgreSQL:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/user_db
    username: postgres
    password: sua_senha
```
Execute a aplicação.

Por padrão:

```text
http://localhost:8080
```

---

### 2. Microsserviço Agendador de Tarefas

Clone o repositório:

```bash
git clone https://github.com/Myckel-ctrl/agendador-tarefas.git
```

Execute a aplicação.

Por padrão:

```text
http://localhost:8081
```

---

### 3. BFF Agendador de Tarefas

Clone o repositório:

```bash
git clone https://github.com/Myckel-ctrl/bff-agendador-tarefas.git
```

Execute a aplicação.

Por padrão:

```text
http://localhost:8083
```

> **Importante:** todos os projetos precisam estar em execução ao mesmo tempo. O BFF depende dos microsserviços de Usuário e Agendador de Tarefas para realizar suas operações.

### Ordem recomendada

```text
1. usuario
      ↓
2. agendador-tarefas
      ↓
3. bff-agendador-tarefas
```

Depois que os três projetos estiverem rodando, o cliente pode realizar as requisições através do BFF.

---

## 🔗 Projetos relacionados

Este projeto faz parte de uma arquitetura composta por três aplicações:

### 👤 Usuário

Microsserviço responsável pelo gerenciamento de usuários e autenticação.

🔗 https://github.com/Myckel-ctrl/usuario

### 📅 Agendador de Tarefas

Microsserviço responsável pelo gerenciamento das tarefas.

🔗 https://github.com/Myckel-ctrl/agendador-tarefas

### 🔀 BFF Agendador de Tarefas

Camada responsável por centralizar as requisições do cliente e realizar a comunicação com os microsserviços.

🔗 https://github.com/Myckel-ctrl/bff-agendador-tarefas

---

## 📂 Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── com/
            └── bff_agendador_tarefa/
                ├── client/
                ├── config/
                ├── controller/
                ├── dto/
                ├── exception/
                ├── security/
                └── service/
```

A aplicação segue uma separação de responsabilidades entre:

* **Controller** → recebe as requisições HTTP
* **Service** → concentra a lógica da aplicação
* **Client** → realiza a comunicação com os microsserviços
* **DTO** → controla os dados de entrada e saída da API
* **Config** → configurações de segurança, Feign e documentação
* **Exception** → tratamento de erros

---

## 🎯 Objetivo do projeto

O objetivo deste projeto é aplicar conceitos de desenvolvimento de aplicações distribuídas utilizando **Spring Boot**, criando uma arquitetura baseada em microsserviços e utilizando um **BFF (Backend for Frontend)** como camada intermediária entre o cliente e os serviços responsáveis pelas regras de negócio.

O projeto também busca aplicar conceitos como:

* Arquitetura em camadas
* Microsserviços
* Comunicação entre APIs REST
* OpenFeign
* Autenticação com JWT
* DTOs
* Tratamento global de exceções
* Validação de dados
* Documentação de APIs com Swagger/OpenAPI

---

## 👨‍💻 Autor

**Myckel de Vasconcelos Mota**
Desenvolvedor Java
