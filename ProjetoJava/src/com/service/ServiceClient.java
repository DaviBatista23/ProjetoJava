package com.service;

import MeuPacote.ValidaCPF;
import MeuPacote.ValidaEmail;
import Repositorios.Cliente;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ServiceClient {

    public static void cadastraCliente() throws IOException, ParseException {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Informe os dados do Cliente: ");

        System.out.println("Digite o Nome: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o E-mail: ");
        String email = leitura.nextLine();
        while (ValidaEmail.isEmail(email) != true) {
            System.out.printf("Erro, E-mail inválido !!!\nTente novamente:\n");
            email = leitura.nextLine();
        }

        System.out.println("Digite o CPF (Apenas números): ");
        String cpf = leitura.nextLine();
        while (ValidaCPF.isCPF(cpf) != true) {
            System.out.printf("Erro, CPF inválido !!!\nTente novamente:\n");
            cpf = leitura.nextLine();
        }

        System.out.println("Digite a Data de nascimento: ");
        String dataNasc = leitura.nextLine();
        while (dataNasc.length() != 10){
            System.out.printf("Erro, data inválida !!!\nTente novamente:\n");
            dataNasc = leitura.nextLine();
        }


        String tipo = "Cliente";

        Cliente newClient = new Cliente(nome, email, cpf, dataNasc, tipo);

        Cliente.salva(newClient);

        System.out.println("\nCliente salvo com sucesso!!");

        Menu.sleep();

        Menu.menu();
    }

    public static void searchByCPF() throws IOException, ParseException {
        System.out.println("\nPESQUISA POR CPF");
        System.out.println("Digite o CPF (Apenas números) ");

        Scanner leitura = new Scanner(System.in);
        String cpf = leitura.nextLine();

        Cliente.searchClientCPF(cpf);
        Menu.sleep();
        Menu.menu();
    }

    public static void pesquisaBairro() throws IOException, ParseException {
        System.out.println("\nPESQUISA POR BAIRRO");
        System.out.println("Digite o Bairro: ");

        Scanner leitura = new Scanner(System.in);
        String bairro = leitura.nextLine();

        Cliente.searchClientBairro(bairro);
        Menu.sleep();
        Menu.menu();
    }

    public static void deleteCpf() throws IOException, ParseException {
        System.out.println("\nREMOVER POR CPF");
        System.out.println("Digite o CPF: ");

        Scanner leitura = new Scanner(System.in);
        String cpf = leitura.nextLine();

        Cliente.delete(cpf);
        Menu.sleep();
        Menu.menu();
    }

}