package com.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {

    public static void menu() throws IOException, ParseException {

        int opção;

        System.out.println("\nMENU INICIAL");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Menu de Cliente");
        System.out.println("2- Menu de Fornecedor");
        System.out.println("3- Cadastrar Produto");
        System.out.println("0- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);
        opção = leitura.nextInt();

        switch (opção) {
            case 1:
                menuCliente();
                break;
            case 2:
                menuFornecedor();
                break;
            case 3:
                ServiceProduct.cadastrarProduto();
                break;
            case 0:
                exitSystem();
                break;
        }
    }

    public static void menuCliente() throws IOException, ParseException {

        int opção;

        System.out.println("\nMenu de Cadastro de Clientes!");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Cadastrar novo Cliente");
        System.out.println("2- Pesquisar Cliente");
        System.out.println("3- Remover Cliente");
        System.out.println("0- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);
        opção = leitura.nextInt();

        switch (opção) {
            case 1:
                ServiceClient.cadastraCliente();
                break;
            case 2:
                menuSearchClient();
                break;
            case 3:
                //Adicionar menu de remover
            case 0:
                exitSystem();
                break;
        }
    }

    public static void exitSystem() {
        System.out.println("\nSaindo do Sistema.");
        System.out.println("Volte sempre!!");
        System.exit(1);
    }

    public static void menuFornecedor() throws IOException, ParseException {

        int opção;

        System.out.println("Menu de Cadastro de Fornecedores: ");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Cadastrar novo Fornecedor");
        System.out.println("2- Pesquisar Fornecedor");
        System.out.println("3- Remover Fornecedor");
        System.out.println("0- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);
        opção = leitura.nextInt();

        switch (opção){
            case 1:
                ServiceProvider.cadastraFornecedor();
                break;
            case 2:
                menuSearchProvider();
                break;
            case 3:
//              Adicionar Menu de remover
            case 0:
                exitSystem();
                break;
        }
    }

    public static void menuSearchClient() throws IOException, ParseException {

        int opção;

        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Pesquisar por CPF");
        System.out.println("2- Pesquisar por Bairro");
        System.out.println("0- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);
        opção = leitura.nextInt();

        switch (opção){
            case 1:
                ServiceClient.searchByCPF();
                break;
            case 2:
                ServiceClient.pesquisaBairro();
                break;
            case 0:
                exitSystem();
                break;
        }
    }

    public static void menuSearchProvider() throws IOException, ParseException {

        int opção;

        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Pesquisar por Serviço");
        System.out.println("2- Pesquisar por CEP");
        System.out.println("0- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);
        opção = leitura.nextInt();

        switch (opção) {
            case 1:
                ServiceProvider.searchByService();
                break;
            case 2:
                ServiceProvider.searchByCEP();
                break;
            case 0:
                exitSystem();
                break;
        }
    }

    public static void sleep() {
        try { Thread.sleep (3000); } catch (InterruptedException ex) {}
        System.out.println("\n----------------");
    }
}
