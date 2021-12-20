package com.service;

import Repositorios.Produto;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ServiceProduct {

    public static void cadastrarProduto() throws IOException, ParseException {
        System.out.println("\nMenu de Cadastro de Produtos!");
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nInforme o nome do produto: ");
        String nome = leitura.nextLine();

        System.out.println("\nInforme o tipo do produto: ");
        String tipo = leitura.nextLine();

        System.out.println("\nInforme a quantidade do produto: ");
        int quantidade = leitura.nextInt();

        boolean saveProduct =  Produto.salva(nome, tipo, quantidade);

        Menu.sleep();

        Menu.menu();
    }
}
