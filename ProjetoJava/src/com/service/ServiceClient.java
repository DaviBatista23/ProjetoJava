package com.service;

import Validation.ValidateCPF;
import Validation.ValidateEmail;
import Repositories.Client;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServiceClient {

    public static void cadastraCliente() throws IOException, ParseException {
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nInforme os dados do Cliente ");

        System.out.println("Digite o Nome: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o E-mail: ");
        String email = leitura.nextLine();
        while (ValidateEmail.isEmail(email) != true) {
            System.out.printf("Erro, E-mail inválido !!!\nTente novamente:\n");
            email = leitura.nextLine();
        }

        System.out.println("Digite o CPF (Apenas números)");
        String cpf = leitura.nextLine();
        while (!ValidateCPF.isCPF(cpf) || ValidateCPF.existsCpf(cpf)) {
            System.out.printf("ERRO!! CPF Já cadastrado ou inválido\n" +
                    "Tente novamente:\n");
            cpf = leitura.nextLine();
        }

        System.out.println("Digite a Data de nascimento: ");
        String dataNasc = leitura.nextLine();
        while (dataNasc.length() != 10) {
            System.out.printf("Erro, data inválida !!!\nTente novamente:\n");
            dataNasc = leitura.nextLine();
        }

        String tipo = "Cliente";

        Client newClient = new Client(nome, email, cpf, dataNasc, tipo);

        salva(newClient);

        System.out.println("\nCliente salvo com sucesso!!");

        Menu.sleep();
        Menu.menu();
    }

    public static void salva(Client cliente) {
        JsonParser jsonParser = new JsonParser();

        try {
            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;

            JsonObject newClient = new JsonObject();
            newClient.addProperty("id", cliente.getId());
            newClient.addProperty("nome", cliente.getNome());
            newClient.addProperty("idade", cliente.getIdade());
            newClient.addProperty("email", cliente.getEmail());
            newClient.addProperty("cpf", cliente.getCpf());
            newClient.addProperty("dataNasc", cliente.getDataNasc());
            newClient.addProperty("tipo", cliente.getTipo());
            newClient.addProperty("endereco", cliente.getEndereco());
            newClient.addProperty("bairro", cliente.getBairro());

            jsonArray.add(newClient);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonClient = gson.toJson(jsonArray);
            FileWriter file = new FileWriter("ProjetoJava\\src\\Db\\DB-Client.json");
            file.write(jsonClient);
            file.flush();
            file.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void searchByCPF() throws IOException, ParseException {
        System.out.println("\nPESQUISA POR CPF");
        System.out.println("Digite o CPF (Apenas números) ");

        Scanner leitura = new Scanner(System.in);
        String cpf = leitura.nextLine();
        while (!ValidateCPF.existsCpf(cpf)) {
            System.out.println("Cliente não encontrado!\nTente novamente:");
            cpf = leitura.nextLine();
        }

        searchClientCPF(cpf);
        Menu.sleep();
        Menu.menu();
    }

    public static void searchClientCPF(String cpf) {

        try {
            JsonParser jsonParser = new JsonParser();

            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().create();
            List<Client> clientes = new ArrayList<>();
            jsonArray.forEach(jsonClient -> {
                        clientes.add(gson.fromJson(jsonClient, Client.class));
                    }
            );

            List<Client> lista2 = clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).collect(Collectors.toList());

            Client cliente = !lista2.isEmpty() ? lista2.get(0) : null;
            if (cliente != null) {
                System.out.println("\nCliente encontrado:");
                System.out.println("\nId: " + cliente.getId());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Idade: " + cliente.getIdade());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Data Nascimento: " + cliente.getDataNasc());
                System.out.println("Tipo: " + cliente.getTipo());
                System.out.println("Endereco: " + cliente.getEndereco());
            }
        } catch (FileNotFoundException | ParseException ignored) {

        }
    }

    public static void pesquisaBairro() throws IOException, ParseException {
        System.out.println("\nPESQUISA POR BAIRRO");
        System.out.println("Digite o Bairro: ");

        Scanner leitura = new Scanner(System.in);
        String bairro = leitura.nextLine();
        while (!existDistrict(bairro)) {
            System.out.println("Cliente não encontrado!\nTente novamente:");
            bairro = leitura.nextLine();
        }

        searchClientBairro(bairro);
        Menu.sleep();
        Menu.menu();
    }

    public static void searchClientBairro(String bairro) {
        try {
            JsonParser jsonParser = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().create();
            List<Client> clientes = new ArrayList<>();
            jsonArray.forEach(jsonClient -> {
                        clientes.add(gson.fromJson(jsonClient, Client.class));
                    }
            );
            clientes.forEach(cliente -> {
                if (cliente.getBairro().equals(bairro)) {
                    System.out.println("\nCliente encontrado:");
                    System.out.println("\nId: " + cliente.getId());
                    System.out.println("Nome: " + cliente.getNome());
                    try {
                        System.out.println("Idade: " + cliente.getIdade());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println("E-mail: " + cliente.getEmail());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Data Nascimento: " + cliente.getDataNasc());
                    System.out.println("Tipo: " + cliente.getTipo());
                    System.out.println("Endereco: " + cliente.getEndereco());
                }
            });

        } catch (FileNotFoundException ignored) {

        }
    }

    public static void deleteCpf() throws IOException, ParseException {
        System.out.println("\nRemover por CPF");
        System.out.println("Digite o CPF: ");

        Scanner leitura = new Scanner(System.in);
        String cpf = leitura.nextLine();
        while (!ValidateCPF.existsCpf(cpf)) {
            System.out.println("Cliente não encontrado!\nTente novamente:");
            cpf = leitura.nextLine();
        }

        deleteByCPF(cpf);
        Menu.sleep();
        Menu.menu();
    }

    public static void deleteName() throws IOException, ParseException {
        System.out.println("\nRemover por Nome");
        System.out.println("Digite o nome completo do cadastro: ");

        Scanner leitura = new Scanner(System.in);
        String nome = leitura.nextLine();
        while (!existName(nome)) {
            System.out.println("Cliente não encontrado!\nTente novamente:");
            nome = leitura.nextLine();
        }

        deleteByName(nome);
        Menu.sleep();
        Menu.menu();
    }

    public static void deleteByCPF(String cpf) {
        try {
            JsonParser jsonParser = new JsonParser();

            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Client> clientes = new ArrayList<>();
            jsonArray.forEach(jsonClient -> {
                        clientes.add(gson.fromJson(jsonClient, Client.class));
                    }
            );

            List<Client> lista2 = new ArrayList<>();

            clientes.forEach(cliente -> {
                if (!cliente.getCpf().equals(cpf)) {
                    lista2.add(cliente);
                }
            });
            System.out.println("\nCliente removido com sucesso!");

            String jsonListClient = gson.toJson(lista2);
            FileWriter file = new FileWriter("ProjetoJava\\src\\Db\\DB-Client.json");
            file.write(jsonListClient);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteByName(String nome) {
        try {
            JsonParser jsonParser = new JsonParser();

            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Client> clientes = new ArrayList<>();
            jsonArray.forEach(jsonClient -> {
                        clientes.add(gson.fromJson(jsonClient, Client.class));
                    }
            );

            List<Client> lista2 = new ArrayList<>();

            clientes.forEach(cliente -> {
                if (!cliente.getNome().equals(nome)) {
                    lista2.add(cliente);
                }
            });
            System.out.println("\nCliente removido com sucesso!");

            String jsonListClient = gson.toJson(lista2);
            FileWriter file = new FileWriter("ProjetoJava\\src\\Db\\DB-Client.json");
            file.write(jsonListClient);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean existName(String name) throws FileNotFoundException {

        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
        JsonArray jsonArray = (JsonArray) obj;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Client> clientes = new ArrayList<>();
        jsonArray.forEach(jsonClient -> {
                    clientes.add(gson.fromJson(jsonClient, Client.class));
                }
        );

        List<Client> lista2 = clientes.stream().filter(cliente ->
                cliente.getNome().equals(name)
        ).collect(Collectors.toList());
        if (!lista2.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean existDistrict(String bairro) throws FileNotFoundException {

        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
        JsonArray jsonArray = (JsonArray) obj;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Client> clientes = new ArrayList<>();
        jsonArray.forEach(jsonClient -> {
                    clientes.add(gson.fromJson(jsonClient, Client.class));
                }
        );

        List<Client> lista2 = clientes.stream().filter(cliente ->
                cliente.getBairro().equals(bairro)
        ).collect(Collectors.toList());
        if (!lista2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static int contaID(int id) throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Client.json"));
        JsonArray jsonArray = (JsonArray) obj;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Client> clientes = new ArrayList<>();
        jsonArray.forEach(jsonClient -> {
                    clientes.add(gson.fromJson(jsonClient, Client.class));
                }
        );
        id = clientes.size() + 1;

        return id;
    }

}