package com.service;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void menu() throws IOException {

        int opção;

        System.out.println("\nMENU INICIAL");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- MENU Cliente");
        System.out.println("2- MENU Fornecedor");
        System.out.println("0- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            menuCliente();
        } if (opção == 2) {
            menuFornecedor();
        }   if (opção == 0){
             exitSystem();
        }

    }

    public static void menuCliente() throws IOException {
        System.out.println("\nMenu de Cadastro de Clientes!");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Cadastrar novo Cliente");
        System.out.println("2- Pesquisar Cliente");
        System.out.println("3- Remover Cliente");
        System.out.println("0- Sair do Sistema");

        int opção;
        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            ServiceClient.cadastraCliente();
        } if (opção == 2) {
            menuSearchClient();
        }   if (opção == 3){
//            Adicionar Menu de remover
        }       if (opção == 0){
                  exitSystem();
    }}

    public static void exitSystem() {
        System.out.println("\nSaindo do Sistema.");
        System.out.println("Volte sempre!!");
        System.exit(1);
    }

    public static void menuFornecedor() throws IOException {
        System.out.println("Menu de Cadastro de Fornecedores: ");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Cadastrar novo Fornecedor");
        System.out.println("2- Pesquisar Fornecedor");
        System.out.println("3- Remover Fornecedor");
        System.out.println("0- Sair do Sistema");

        int opção;
        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            ServiceProvider.cadastraFornecedor();
        } if (opção == 2) {
            menuSearchProvider();
        }   if (opção == 3){
//            Adicionar Menu de remover
        }     if (opção == 0) {
                exitSystem();
        }
    }

    public static void menuSearchClient() throws IOException {
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Pesquisar por CPF");
        System.out.println("2- Pesquisar por Bairro");
        System.out.println("0- Sair do Sistema");

        int opção;
        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            ServiceClient.searchByCPF();
        } if (opção == 2) {
            ServiceClient.pesquisaBairro();
        }   if (opção == 0) {
            exitSystem();
        }
    }

    public static void menuSearchProvider() throws IOException {
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Pesquisar por Serviço");
        System.out.println("2- Pesquisar por CEP");
        System.out.println("0- Sair do Sistema");

        int opção;
        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            ServiceProvider.searchByService();
        } if (opção == 2) {
            ServiceProvider.searchByCEP();
        }   if (opção == 0) {
            exitSystem();
        }
    }
    public static void sleep() {
        try { Thread.sleep (3000); } catch (InterruptedException ex) {}
        System.out.println("\n----------------");
    }
}
