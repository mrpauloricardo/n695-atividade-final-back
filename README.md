# Desenvolvimento para Plataformas Web - Back-End

Este projeto faz parte da Atividade Final da disciplina de Desenvolvimento para Plataformas Web. Ele consiste em uma aplicação back-end desenvolvida com Java e Spring Boot.

## Funcionalidades

- **Cadastro de Usuários**: Permite o cadastro de novos usuários com id, nome e email.
- **Consulta de Usuários**: Permite consultar usuários cadastrados pelo nome de usuário.
- **Listagem de Usuários**: Exibe uma lista de todos os usuários cadastrados.
- **Edição de Usuários**: Permite editar os dados de um usuário existente.
- **Exclusão de Usuários**: Permite excluir um usuário pelo id.
- **Criação do Usuário Admin:** Cria um usuário com permissão de administrador, o login padrão é username: admin e senha: admin123 
- **Somente um administrador pode remover um usuário** 

## Requisitos

- Java Development Kit (JDK) 17 ou superior
- Maven 3.9.6 ou superior
- MongoDB Atlas para o banco de dados

## Instalação

### 1. Clonar o Repositório

Primeiro, clone o repositório para o seu ambiente local:

```bash
git clone https://github.com/mrpauloricardo/n695-atividade-final-back.git
cd n695-atividade-final-back
```

### 2. Configurar o Java SDK

Certifique-se de que o JDK 17 está instalado. Você pode baixá-lo [aqui](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

Para verificar se o JDK está instalado corretamente, execute:

```bash
java --version
```

A saída deve ser algo como:

```
java version "17.0.9"
```

### 3. Configurar o Maven

Certifique-se de que o Maven está instalado. Você pode baixá-lo [aqui](https://maven.apache.org/download.cgi).

Para verificar se o Maven está instalado corretamente, execute:

```bash
mvn --version
```

A saída deve ser algo como:

```
Apache Maven 3.9.6
```

### 4. Configurar o MongoDB Atlas

1. Crie uma conta no [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
2. Configure um novo cluster.
3. Crie um usuário do banco de dados com as permissões necessárias.
4. Obtenha a string de conexão do MongoDB Atlas. Ela deve ter este formato:

```
mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority
```

### 5. Configurar Variáveis de Ambiente

No arquivo `application.properties`, configure a string de conexão do MongoDB:

```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority
```

### 6. Construir e Executar o Projeto

Para construir o projeto, navegue até o diretório do projeto e execute:

```bash
mvn clean install
```

Para executar a aplicação, use:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Estrutura dos Endpoints

A API fornece os seguintes endpoints:

- `POST /api/auth/signin` - Realiza o login de um usuário já cadastrado
- `POST /api/auth/signup` - Cadastra um novo usuário
- `GET /api/auth/clients` - Retorna a lista de usuários cadastrados
- `GET /api/auth/clients/{username}` - Retorna um usuário pelo nome de usuário
- `PUT /api/auth/clients/{id}` - Atualiza um usuário existente
- `DELETE /api/auth/clients/{id}` - Remove um usuário por seu id

## Nota

O front-end desta aplicação pode ser encontrado [aqui](https://github.com/mrpauloricardo/n695-atividade-final-front).