package com.service;

import Repositorios.Cliente;

import java.io.IOException;
import java.util.Scanner;

public class ServiceClient {

    public static void cadastraCliente() throws IOException {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Informe os dados do Cliente: ");

        System.out.println("Digite o Nome: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o E-mail: ");
        String email = leitura.nextLine();

        System.out.println("Digite o CPF: ");
        String cpf = leitura.nextLine();

        System.out.println("Digite a Data de nascimento: ");
        String dataNasc = leitura.nextLine();

        String tipo = "Cliente";

        Cliente newClient = new Cliente(nome, email, cpf, dataNasc, tipo);

        Cliente.salva(newClient);

        System.out.println("\nCliente salvo com sucesso!!");

        Menu.sleep();

        Menu.menu();
    }

    public static void searchByCPF() throws IOException {
        System.out.println("\nPESQUISA POR CPF");
        System.out.println("Digite o CPF: ");

        Scanner leitura = new Scanner(System.in);
        String cpf = leitura.nextLine();

        Cliente.searchClientCPF(cpf);
        Menu.sleep();
        Menu.menu();
    }

    public static void pesquisaBairro() throws IOException {
        System.out.println("\nPESQUISA POR BAIRRO");
        System.out.println("Digite o Bairro: ");

        Scanner leitura = new Scanner(System.in);
        String bairro = leitura.nextLine();

        Cliente.searchClientBairro(bairro);
        Menu.sleep();
        Menu.menu();
    }



}