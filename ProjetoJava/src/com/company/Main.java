package com.company;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("davi", "davi@email.com", "47637813835", "1995-12-04");
        Cliente cliente2 = new Cliente("Teste", "Teste@email.com", "12345678985", "1993-11-16");

        Endereço endereco1 = new Endereço("Rua Ivai", "Tatuapé", 33, "casa", "03030-010");
        cliente1.setEndereco(endereco1);

        System.out.println("O ID do cliente é: " + cliente1.getId());
        System.out.println("O ID do cliente é: " + cliente2.getId());
        System.out.println("A idade do cliente é: " + cliente2.getIdade());
        System.out.println("O nome do cliente é hhh: " + cliente2.getNome());

        cliente1.getEndereco().showAdrress();
    }
}
