package com.service;

import Repositorios.Cliente;
import java.util.Scanner;

public class ServiceClient {

    public static void cadastraCliente() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = leitura.nextLine();

        System.out.println("Digite seu E-mail: ");
        String email = leitura.nextLine();

        System.out.println("Digite seu CPF: ");
        String cpf = leitura.nextLine();

        System.out.println("Digite sua Data de nascimento: ");
        String dataNasc = leitura.nextLine();

        Cliente cliente1 = new Cliente(nome, email, cpf, dataNasc);

        try { Thread.sleep (3000); } catch (InterruptedException ex) {}
        System.out.println("\n----------------");

        TrazerCliente(cliente1);

        try { Thread.sleep (3000); } catch (InterruptedException ex) {}
        System.out.println("\n----------------");

        Menu.menu();
    };

    public static void TrazerCliente(Cliente cliente) {

        System.out.println("O ID do cliente é: " + cliente.getId());
        System.out.println("O nome do cliente é: " + cliente.getNome());
        System.out.println("A idade do cliente é: " + cliente.getIdade());
        System.out.println("O e-mail do cliente é: " + cliente.getEmail());
        System.out.println("O CPF do cliente é: " + cliente.getCpf());
//        cliente.getEndereco().showAdrress();

    }

}
