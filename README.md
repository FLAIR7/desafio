# Desafio
Desafio backend em java

<b>Java</b>
<b>H2</b>
- Usuário: aa
- senha: 


# Premissas:
Criar uma API usando Spring Boot.
Utilizar um banco de dados em memória (HSQLDB ou H2).
Não é necessário desenvolver front-end, apenas o back-end.

# Teste: 

Desenvolver um serviço que seja capaz de gerar uma venda.
Uma venda é composta por id, data da venda, valor, vendedor id e vendedor nome.


# Sua tarefa é desenvolver os serviços REST abaixo:

- Criar uma nova venda
- Retornar a lista de vendedores com os campos: nome, total de vendas do vendedor e média de vendas diária, conforme o período informado por parâmetro


# Como fazer uma venda:
1. <b>Crie um vendedor</b>
```
curl -X POST -H "Content-Type: application/json" -d '{"nome: "Diego"}' http://localhost:8080
```
2. <b>Faça uma venda e associe com o vendedor</b>
```
curl -X post -H "Content-Type: application/json" -d '{"dataVenda": "2021-05-19", "valor": 500}' http://localhost:8080/29b11df1-f5c2-4437-beba-cbc33e0ee1c0 
```

# Outros verbos http:

<b>Filtra as vendas do vendedor '29b11df1-f5c2-4437-beba-cbc33e0ee1c0' na data de 2022/03/19:</b>
```http://localhost:8080/29b11df1-f5c2-4437-beba-cbc33e0ee1c0/dataVenda?=2022-03-19```

<b>Deleta o vendedor com id '29b11df1-f5c2-4437-beba-cbc33e0ee1c0':</b> 
```curl -X DELETE http://localhost/29b11df1-f5c2-4437-beba-cbc33e0ee1c0 ```

<b>Atualiza o vendedor com id '29b11df1-f5c2-4437-beba-cbc33e0ee1c0':</b>  
```curl -X PUT -H "Content-Type: application/json" -d '{"nome": "Carlos"}' http://localhost/29b11df1-f5c2-4437-beba-cbc33e0ee1c0```


