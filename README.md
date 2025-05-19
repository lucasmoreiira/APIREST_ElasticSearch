
# API REST com Spring Boot e Elasticsearch

Este projeto é uma API REST para gerenciar produtos utilizando Spring Boot e Elasticsearch hospedado na Elastic Cloud (com URI personalizada).

## 🔖 Estrutura de Pastas

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.demo
│   │   │       ├── controller        # Controladores REST
│   │   │       ├── model             # Modelos de dados (Entidades)
│   │   │       ├── repository        # Interfaces de acesso ao Elasticsearch
│   │   │       └── service           # Lógica de negócios
│   │   └── resources
│   │       └── application.properties # Configurações do projeto
```

---

## ⚙️ Configuração do Elasticsearch (Elastic Cloud)

No arquivo `application.properties`, utilize a URI no lugar de `localhost`:

```properties
spring.elasticsearch.uris=https://<seu-endpoint>.es.io:443
spring.elasticsearch.username=<seu-usuario>
spring.elasticsearch.password=<sua-senha>
```

---

## 🧩 CRUD - Exemplos de Requisições HTTP

> Substitua `<seu-endpoint>` pelo seu endpoint da Elastic Cloud  
> Substitua `ID_DO_DOCUMENTO` pelo ID real do documento

### 📘 GET - Buscar todos os produtos

```
GET https://<seu-endpoint>.es.io:443/produtos/_search
```

#### Corpo (opcional para busca por match_all):
```json
{
  "query": {
    "match_all": {}
  }
}
```

---

### 📗 GET by ID - Buscar um produto específico

```
GET https://<seu-endpoint>.es.io:443/produtos/_doc/ID_DO_DOCUMENTO
```

---

### 📙 POST - Criar um novo produto

```
POST https://<seu-endpoint>.es.io:443/produtos/_doc
```

#### Corpo:
```json
{
  "nome": "Furadeira",
  "descricao": "Furadeira industrial potente",
  "preco": 250.00
}
```

---

### 📒 PUT - Atualizar um produto existente

```
PUT https://<seu-endpoint>.es.io:443/produtos/_doc/ID_DO_DOCUMENTO
```

#### Corpo:
```json
{
  "nome": "Furadeira 2.0",
  "descricao": "Furadeira com bateria",
  "preco": 300.00
}
```

---

### 🗑️ DELETE - Remover um produto

```
DELETE https://<seu-endpoint>.es.io:443/produtos/_doc/ID_DO_DOCUMENTO
```

---

## 🌐 Acessando o Elasticsearch via Web

1. Acesse o [Elastic Cloud Console](https://cloud.elastic.co/)
2. Faça login com sua conta
3. Vá em "Deployments" → selecione seu projeto
4. Copie o **endpoint** do Elasticsearch
5. Utilize esse endpoint para configurar seu `application.properties` e realizar requisições HTTP

---

## ✅ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Elasticsearch (Elastic Cloud)
- Maven
- Insomnia/Postman para testes de API

---

## ✍️ Autor

Lucas Moreira
