package com.company;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("davi", "davi@email.com", "47637813835", "1995-12-04");
        Cliente cliente2 = new Cliente("Teste", "Teste@email.com", "12345678985", "1993-11-16");

        Endereço endereco1 = new Endereço("Rua Ivai", "Tatuapé", 33, "casa", "03030-010");
        cliente1.setEndereco(endereco1);

        System.out.println("O ID do cliente é: " + cliente1.getId());
        System.out.println("O nome do cliente é: " + cliente1.getNome());
        System.out.println("A idade do cliente é: " + cliente1.getIdade());
        System.out.println("O e-mail do cliente é: " + cliente1.getEmail());
        System.out.println("O CPF do cliente é: " + cliente1.getCpf());
        cliente1.getEndereco().showAdrress();
        System.out.println("\nA Data de nascimento do cliente é: " + cliente1.getDataNasc());

        System.out.println("--------------------------------- ");

        Fornecedor fornecedor1 = new Fornecedor("1234567891010","Fornecedor1", "Fornecedor1", "2000-10-10", "fornecedor1@email.com", "Fornecedor");
        Fornecedor fornecedor2 = new Fornecedor("2222222222222","Fornecedor2", "Fornecedor2", "2000-11-11", "fornecedor2@email.com", "Fornecedor");

        Endereço endereco2 = new Endereço("Rua do Fornecedor", "Tatuapé", 123, "Comercial", "01234-567");
        fornecedor1.setEndereco(endereco2);

        System.out.println("O CNPJ do fornecedor é: " + fornecedor1.getCnpj());
        System.out.println("O Nome do fornecedor é: " + fornecedor1.getNome());
        System.out.println("A Nome Fantasia do fornecedor é: " + fornecedor1.getNomeFant());
        System.out.println("A Data de Fundação do fornecedor é: " + fornecedor1.getDataFund());
        System.out.println("O E-mail do fornecedor é: " + fornecedor1.getEmail());
        fornecedor1.getEndereco().showAdrress();
        System.out.println("\nO serviço do fornecedor é: " + fornecedor1.getService());

        System.out.println("--------------------------------- ");

        Produto produto1 = new Produto("Caderno", "Escolar", 50);
        Produto produto2 = new Produto("Caneta", "Escolar", 100);

        System.out.println("O Nome do produto é: " + produto1.getNome());
        System.out.println("O Tipo do produto é: " + produto1.getTipo());
        System.out.println("A Quantidade do produto é: " + produto1.getQuantidade());
    };
}

