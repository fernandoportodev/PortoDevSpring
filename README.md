<h1>Aplicação Java Spring + MariaDB</h1>

## Introdução
Esta aplicação é um sistema de gerenciamento de usuários desenvolvido em Java utilizando o Spring Boot. O objetivo é fornecer um CRUD simples para manipulação de dados de usuários, com integração ao banco de dados MariaDB.

## Pré-requisitos
- Java JDK 21
- Maven 3.3.4
- MariaDB


##

 <h3>CRUD de Usuários</h3> 
<h4>POST /user</h4> 
  <code>createUser()</code> - Criação de usuário ao passar no body os campos "name" e "email"
  
  ```
  {
    "name": "Teste",
    "email": "teste@teste.com"
  }
  ```

<h4>GET /user</h4>
<code>getAllUsers()</code> - Obter todos os usuários cadastrados; <br>
<h4>GET /user/{id}</h4>
<code>getUserById()</code> - Obter usuário à partir do parâmetro "id";

<h4>PUT /user/{id}</h4>
<code>updateUser()</code> - Atualização dos dados do usuário cadastrado à partir do parâmetro "id"

<h4>DELETE /user/{id}</h4>
<code>deleteUser()</code> - Exclui usuário do banco de dados à partir do parâmetro "id"

##

```markdown
## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.
