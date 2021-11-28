package com.service;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void menu() throws IOException {

        int opção;

        System.out.println("\nMENU INICIAL");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Cadastro Cliente");
        System.out.println("2- Cadastro Fornecedor");
        System.out.println("3- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            menuCliente();
        } if (opção == 2) {
            menuFornecedor();
        }   if (opção == 3){
            exitSystem();
        }

    }

    public static void menuCliente() throws IOException {
        System.out.println("Menu de Cadastro de Clientes: ");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Cadastrar novo Cliente");
        System.out.println("2- Pesquisar Cliente");
        System.out.println("3- Remover Cliente");

        int opção;
        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            ServiceClient.cadastraCliente();
        } if (opção == 2) {
//            Adicionar Menu de pesquisa
        }   if (opção == 3){
//            Adicionar Menu de remover
        }

    }

    public static void exitSystem() {
        System.out.println("Saindo do Sistema.");
        System.out.println("Volte sempre!!");
        System.exit(1);
    }

    public static void menuFornecedor() throws IOException {
        System.out.println("Menu de Cadastro de Fornecedores: ");
        System.out.println("\nDigite a opção desejada: ");
        System.out.println("1- Cadastrar novo Fornecedor");
        System.out.println("2- Pesquisar Fornecedor");
        System.out.println("3- Remover Fornecedor");

        int opção;
        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            ServiceProvider.cadastraFornecedor();
        } if (opção == 2) {
//            Adicionar Menu de pesquisa
        }   if (opção == 3){
//            Adicionar Menu de remover
        }

    }

}
