package com.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ServiceAdress {

    private static String logradouro;
    public static String bairro;
    private static int numero;
    private static String complemento;
    private static String cep;

    public ServiceAdress(String rua, String bairro, int numero, String complemento, String cep) {
        ServiceAdress.logradouro = rua;
        ServiceAdress.bairro = bairro;
        ServiceAdress.numero = numero;
        ServiceAdress.complemento = complemento;
        ServiceAdress.cep = cep;
    }

    public static String cadastrarEndereço() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nInforme o Endereço: ");
        System.out.println("Digite o CEP (Apenas números)");
        ServiceAdress.cep = leitura.nextLine();
        String json;
        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();

            // JOptionPane.showMessageDialog(null, json);

            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = new String[30];
            array = json.split("\n");

            // JOptionPane.showMessageDialog(null, array);

            String logradouro = array[7];
            String bairro = array[15];
            String cidade = array[19];
            String uf = array[23];

            System.out.println(logradouro + " " + bairro + " " + cidade + " " + uf);


            System.out.println("Digite o número: ");
            String numero = leitura.nextLine();

            System.out.println("Digite o complemento: ");
            String complemento = leitura.nextLine();

            String space = " ";
            String sv = ", ";

            return logradouro + space + numero + sv + complemento + sv + bairro + sv + cep;

        } catch (Exception exceptionCep) {
            throw new RuntimeException(exceptionCep);
        }

    }


    public static String getLogradouro() {
        return logradouro;
    }

    public void setRua(String rua) {
        this.logradouro = rua;
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