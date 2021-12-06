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

    public void showAdrress() {
        System.out.println("O Endereço é: " );
        System.out.printf(this.rua
                + " " + this.numero
                + ", " + this.complemento
                + ", " + this.bairro
                + ", " + this.cep);
    }

    public static String cadastrarEndereço() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Informe o Endereço: ");

        String space = ", ";
        System.out.println("Digite o nome da Rua: ");
        String rua = leitura.nextLine();

        System.out.println("Digite o número: ");
        String numero = leitura.nextLine();

        System.out.println("Digite o complemento: ");
        String complemento = leitura.nextLine();

        System.out.println("Digite o Bairro: ");
        String bairro = leitura.nextLine();

        System.out.println("Digite o CEP: ");
        String cep = leitura.nextLine();

        return rua + space + numero + space + complemento + space + bairro + space + cep;
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
