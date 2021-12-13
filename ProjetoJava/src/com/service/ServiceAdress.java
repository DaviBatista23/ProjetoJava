package com.service;

import java.util.Scanner;

public class ServiceAdress {

    private static String rua;
    private static String bairro;
    private static int numero;
    private static String complemento;
    private static String cep;

    public ServiceAdress(String rua, String bairro, int numero, String complemento, String cep) {
        ServiceAdress.rua = rua;
        ServiceAdress.bairro = bairro;
        ServiceAdress.numero = numero;
        ServiceAdress.complemento = complemento;
        ServiceAdress.cep = cep;
    }

    public static String cadastrarEndereço() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nInforme o Endereço: ");

        String space = " ";
        String sv = ", ";

        System.out.println("Digite o nome da Rua: ");
        String rua = leitura.nextLine();

        System.out.println("Digite o número: ");
        String numero = leitura.nextLine();

        System.out.println("Digite o complemento: ");
        String complemento = leitura.nextLine();

        System.out.println("Digite o Bairro: ");
        ServiceAdress.bairro = leitura.nextLine();

        System.out.println("Digite o CEP: ");
        ServiceAdress.cep = leitura.nextLine();

        return rua + space + numero + sv + complemento + sv + bairro + sv + cep;
    }

    public static String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public static String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public static int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public static String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public static String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
