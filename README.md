# Projeto Java
### Projeto criado para exercer os aprendizados adquiridos com a trilha de estudos da Alura.

## Objetivo

### Fazer um sistema em Java, que servirá como um cadastro de clientes e fornecedores. As entidades "cliente e fornecedor" seguem o seguinte padrão:

#### Cliente:
* Código;
* Nome;
* Idade;
* E-mail;
* CPF;
* Endereço (Deve conter rua, bairro, nÚmero, complemento e CEP);
* Data de nascimento.

#### Fornecedor:
* CNPJ;
* Nome;
* Nome fantasia;
* Data de fundação;
* Endereço (Deve conter rua, bairro, número, complemento e CEP);
* E-mail;
* Tipo de serviço.

#### Produto:
* Nome;
*	Tipo;
* Quantidade.

### O sistema deverá prover um menu principal, no qual o usuário escolhe se quer usar o cadastro de cliente ou de fornecedor. Além dessas opções, deve existir uma opção para sair do sistema. 

### O cadastro de cliente deve prover as seguintes funcionalidades:
* Inserir Cliente (o cliente só poderá ser inserido se não existir nenhum cliente com o mesmo  CPF na lista);
* Remover cliente pelo CPF;
* Remover cliente pelo nome (deve remover todos os clientes com nome igual ao do parâmetro);
* Pesquisar cliente por CPF;
* Pesquisar clientes por bairro (Que deve retornar todos os clientes por bairro);

### O cadastro de fornecedores deve prover as seguintes funcionalidades:

* Inserir fornecedor (o fornecedor só poderá ser inserido se não existir nenhum fornecedor com o mesmo CNPJ na lista);
* Remover fornecedor pelo CNPJ;
* Pesquisar fornecedor por tipo de serviço prestado;
* Pesquisar fornecedor por CEP (Que deve retornar todos os fornecedores localizados no CEP informado).

### Toda vez que o usuário concluir uma operação, ou seja, executar alguma das opções acima, ele deve retornar para o menu principal para escolher uma outra opção.

## Cadastro de produto
### Implemente o método cadastrarProduto. Um produto só poderá ser cadastrado caso não exista um produto com o mesmo nome e tipo na lista e caso a lista também não esteja cheia. Caso já exista um produto com o mesmo nome na lista, incremente a quantidade. Caso essa quantidade seja maior que 1000, o produto não poderá ser cadastrado. O método retornará um booleano informando se foi cadastrado com sucesso ou não.

## Observações: 

* Criar uma classe principal para controlar os menus;
* Cliente e Fornecedor devem ter seus próprios repositórios;
* Os repositórios devem ser singleton;
* Todas as classes modelo devem ter getters e setters.
