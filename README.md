# banco

A ideia desse projeto, é criar um banco (MYSQL), relacionado a uma base de dados com uma tabela cliente e uma tabela caixa. 
A tabela cliente possui 3 colunas: cpf, nome e valor (saldo atual da conta). Sendo o cpf a chave primária desta tabela.


![image](https://user-images.githubusercontent.com/117181402/199253274-c93af8ee-8b34-44e1-b30b-ad6310dd6022.png)

E a tabela caixa possui 5 colunas: id, quantidade de notas de 100, 50, 20 e 10.

![image](https://user-images.githubusercontent.com/117181402/199253708-d8aa5933-de8e-4baa-b2f5-ee08d77cccce.png)

<br /> 

Essa API é utilizada para inserir valores na conta de clientes, depositar dinheiro no caixa do banco e sacar dinheiro de um cliente. 

<br />

Para que a tabela "cliente" seja criada na base de dados, se utiliza a rota: localhost:8080/banco/creditarValorContaCliente

![image](https://user-images.githubusercontent.com/117181402/199249905-a9dcadad-689c-48f7-89ab-ab19ec43c6c8.png)

O valor inserido é 0 na criação, para que sejam usados os valores já utilizados na aplicação. 
Mas pode ser inserido qualquer outro valor para depósito.


<br />

Já para se criar a tabela "caixa", a rota é: localhost:8080/banco/salvaDinheiroCaixa

![image](https://user-images.githubusercontent.com/117181402/199250708-390fa748-94da-46a5-b870-3b5e739c9b49.png)

Na criaçãos, Os valores inseridos para a quantidade de cédulas de cada nota deve ser 0, com a mesma lógica da tabela "cliente", e o valor de id = 1, pois o caixa é único.
Para depositar dinheiro no caixa, pode se colocar outro valor, porém o caixa não aceita mais de 100 cédulas de um só valor.

<br />

E por fim, para sacar dinheiro de uma conta, a rota a ser utilizada é: localhost:8080/banco/sacarConta

![image](https://user-images.githubusercontent.com/117181402/199251705-1a413496-005a-42af-b20e-82c9ba629c54.png)

Para isso, passa-se o cpf do cliente e o valor a ser sacado.
A aplicação não altera valores na base, caso o valor a ser sacado seja maior que o saldo atual do cliente, ou que as notas disponíveis não sejam sudficientes para o valor pedido.


