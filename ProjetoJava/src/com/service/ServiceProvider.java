package com.service;

import Repositorios.Fornecedor;

import java.io.IOException;
import java.util.Scanner;

public class ServiceProvider {

    public static void cadastraFornecedor() throws IOException {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Informe os dados do Fornecedor: ");

        System.out.println("Digite o Nome: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o Nome Fantasia: ");
        String nomeFant = leitura.nextLine();

        System.out.println("Digite o E-mail: ");
        String email = leitura.nextLine();

        System.out.println("Digite o CNPJ: ");
        String cnpj = leitura.nextLine();

        System.out.println("Digite a Data de Fundação: ");
        String dataFund = leitura.nextLine();

        System.out.println("Digite o Serviço: ");
        String service = leitura.nextLine();

        String tipo = "Fornecedor";

        Fornecedor newProvider = new Fornecedor(cnpj, nome, nomeFant, dataFund, email, service, tipo);

        Fornecedor.salva(newProvider);

        System.out.println("\nFornecedor salvo com sucesso!!");

        Menu.sleep();

        Menu.menu();
    }

}