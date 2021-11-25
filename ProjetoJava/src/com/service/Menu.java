package com.service;

import java.util.Scanner;

public class Menu {

    public static void menu() {

        int opção;

        System.out.println("Bem vindo ao Sistema!!");
        System.out.println("1- Cadastro Cliente");
        System.out.println("2- Cadastro Fornecedor");
        System.out.println("3- Sair do Sistema");

        Scanner leitura = new Scanner(System.in);

        opção = leitura.nextInt();
        if (opção == 1) {
            ServiceClient.cadastraCliente();
        } if (opção == 2) {
            ServiceClient.cadastraCliente();
        }   if (opção == 3){
            ServiceClient.cadastraCliente();
        }


    }

}
