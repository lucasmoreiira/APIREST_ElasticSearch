# 📘 API REST com Spring Boot + Elasticsearch

Este projeto é uma API REST para cadastro de produtos, utilizando **Spring Boot** e **Elasticsearch** como banco de dados.

---

## 📁 Estrutura de Pastas

```
src
├── main
│   ├── java
│   │   └── com.example.demo
│   │       ├── controller       # Camada de controle (endpoints REST)
│   │       ├── model            # Representa a entidade Produto
│   │       ├── repository       # Interface com o Elasticsearch
│   │       └── service          # Lógica de negócio
│   └── resources
│       └── application.properties  # Configurações da aplicação
```

---

## 📦 Camadas do Projeto

### 🔹 `model/Produto.java`
Define o modelo da entidade **Produto**, com campos como:
```java
@Document(indexName = "produtos")
public class Produto {
    private String id;
    private String nome;
    private String descricao;
    private Double preco;
}
```

### 🔹 `controller/ProdutoController.java`
Expõe os endpoints REST para interagir com a API:
- `GET /produtos`
- `GET /produtos/{id}`
- `POST /produtos`
- `PUT /produtos/{id}`
- `DELETE /produtos/{id}`

### 🔹 `service/ProdutoService.java`
Contém a lógica de negócio, intermediando o controller e o repository.

### 🔹 `repository/ProdutoRepository.java`
Extende `ElasticsearchRepository`, fornecendo métodos como `save`, `findById`, `deleteById`, etc.

---

## 🔌 Configuração

No `application.properties`, configure com a URI completa do Elasticsearch (ex: MongoDB Atlas ou serviços em nuvem):

```properties
spring.elasticsearch.uris=https://<usuario>:<senha>@<host>.cloud.elastic-cloud.com:9243
spring.elasticsearch.username=<usuario>
spring.elasticsearch.password=<senha>
```

Substitua `<usuario>`, `<senha>` e `<host>` pelas informações reais fornecidas pelo serviço Elasticsearch.

---

## 🌐 Requisições HTTP

Você pode usar o **Insomnia**, **Postman** ou **cURL** para testar a API.

### 📥 POST - Criar Produto

```
POST http://localhost:8080/produtos
Content-Type: application/json

{
  "nome": "Furadeira",
  "descricao": "Furadeira elétrica 500W",
  "preco": 199.90
}
```

---

### 📤 GET - Listar Todos os Produtos

```
GET http://localhost:8080/produtos
```

---

### 🔎 GET by ID

```
GET http://localhost:8080/produtos/{id}
```

Substitua `{id}` pelo ID retornado no `POST`.

---

### ✏️ PUT - Atualizar Produto

```
PUT http://localhost:8080/produtos/{id}
Content-Type: application/json

{
  "nome": "Furadeira Bosch",
  "descricao": "Furadeira profissional 750W",
  "preco": 299.90
}
```

---

### ❌ DELETE - Excluir Produto

```
DELETE http://localhost:8080/produtos/{id}
```

---

## 🧭 Usando o Elasticsearch Web

1. Acesse o console Kibana pela interface do provedor (por exemplo, Elastic Cloud).

2. Vá até **Dev Tools** e execute comandos como:

### 🔍 Buscar todos os documentos da index `produtos`:

```json
GET produtos/_search
{
  "query": {
    "match_all": {}
  }
}
```

### 🔍 Buscar produto por nome:

```json
GET produtos/_search
{
  "query": {
    "match": {
      "nome": "furadeira"
    }
  }
}
```

---

## ✅ Requisitos

- Java 17+
- Spring Boot
- Conta no Elasticsearch (Ex: Elastic Cloud)
- Ferramenta de testes como Postman ou Insomnia

---

## 💡 Autor

Feito por [Seu Nome].