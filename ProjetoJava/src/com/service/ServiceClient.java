package com.service;

import com.google.gson.Gson;
import Repositorios.Cliente;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ServiceClient {

    public static void cadastraCliente() throws IOException {
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

        sleep();

        trazerCliente(cliente1);

        sleep();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonClient =  gson.toJson(cliente1);

        System.out.println("Cliente salvo com sucesso!!");

        FileWriter fileWriter = new FileWriter("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\Db.json");
        fileWriter.write(jsonClient);
        fileWriter.flush();
        fileWriter.close();


        sleep();
        Menu.menu();
    };

    public static void trazerCliente(Cliente cliente) {

        System.out.println("O ID do cliente é: " + cliente.getId());
        System.out.println("O nome do cliente é: " + cliente.getNome());
        System.out.println("A idade do cliente é: " + cliente.getIdade());
        System.out.println("O e-mail do cliente é: " + cliente.getEmail());
        System.out.println("O CPF do cliente é: " + cliente.getCpf());
//        cliente.getEndereco().showAdrress();

    }

    public static void sleep() {
        try { Thread.sleep (3000); } catch (InterruptedException ex) {}
        System.out.println("\n----------------");
    }
}
