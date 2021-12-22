package com.service;

import Repositories.Provider;
import Validation.ValidateCNPJ;
import Validation.ValidateEmail;
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

public class ServiceProvider {

    public static void cadastraFornecedor() throws IOException, ParseException {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Informe os dados do Fornecedor: ");

        System.out.println("Digite o Nome: ");
        String nome = leitura.nextLine();

        System.out.println("Digite o Nome Fantasia: ");
        String nomeFant = leitura.nextLine();

        System.out.println("Digite o E-mail: ");
        String email = leitura.nextLine();
        while (ValidateEmail.isEmail(email) != true) {
            System.out.printf("Erro, E-mail inválido !!!\nTente novamente:\n");
            email = leitura.nextLine();
        }

        System.out.println("Digite o CNPJ (Apenas números) ");
        String cnpj = leitura.nextLine();
        while (!ValidateCNPJ.isCNPJ(cnpj) || ValidateCNPJ.existCnpj(cnpj)) {
            System.out.println("EERRO!! CNPJ Já cadastrado ou inválido\n" +
                    "Tente novamente:\n");
            cnpj = leitura.nextLine();
        }

        System.out.println("Digite a Data de Fundação: ");
        String dataFund = leitura.nextLine();
        while (dataFund.length() != 10) {
            System.out.printf("Erro, data inválida !!!\nTente novamente:\n");
            dataFund = leitura.nextLine();
        }

        System.out.println("Digite o Serviço: ");
        String service = leitura.nextLine();

        String tipo = "Fornecedor";

        Provider newProvider = new Provider(cnpj, nome, nomeFant, dataFund, email, service, tipo);

        salva(newProvider);

        System.out.println("\nFornecedor salvo com sucesso!!");

        Menu.sleep();
        Menu.menu();
    }

    public static void salva(Provider fornecedor) {
        JsonParser jsonParser = new JsonParser();

        try {
            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Provider.json"));
            JsonArray jsonArray = (JsonArray) obj;

            JsonObject newProvider = new JsonObject();
            newProvider.addProperty("cnpj", fornecedor.getCnpj());
            newProvider.addProperty("nome", fornecedor.getNome());
            newProvider.addProperty("nomeFant", fornecedor.getNomeFant());
            newProvider.addProperty("dataFund", fornecedor.getDataFund());
            newProvider.addProperty("email", fornecedor.getEmail());
            newProvider.addProperty("service", fornecedor.getService());
            newProvider.addProperty("tipo", fornecedor.getTipo());
            newProvider.addProperty("cep", fornecedor.getCep());
            newProvider.addProperty("endereco", fornecedor.getEndereco());

            jsonArray.add(newProvider);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonProvider = gson.toJson(jsonArray);
            FileWriter file = new FileWriter("ProjetoJava\\src\\Db\\DB-Provider.json");
            file.write(jsonProvider);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchByService() throws IOException, ParseException {
        System.out.println("\nPESQUISA POR TIPO DE SERVIÇO");
        System.out.println("Digite o SERVIÇO: ");

        Scanner leitura = new Scanner(System.in);
        String service = leitura.nextLine();
        while (!existService(service)) {
            System.out.println("Cliente não encontrado!\nTente novamente:");
            service = leitura.nextLine();
        }

        searchProviderService(service);
        Menu.sleep();
        Menu.menu();
    }

    public static void searchByCEP() throws IOException, ParseException {
        System.out.println("\nPESQUISA POR CEP (Apenas números)");
        System.out.println("Digite o CEP: ");

        Scanner leitura = new Scanner(System.in);
        String cep = leitura.nextLine();
        while (!existCep(cep)) {
            System.out.println("Cliente não encontrado!\nTente novamente:");
            cep = leitura.nextLine();
        }

        searchProviderCEP(cep);
        Menu.sleep();
        Menu.menu();

    }

    public static void searchProviderService(String service) {
        try {
            JsonParser jsonParser = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Provider.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().create();
            List<Provider> fornecedores = new ArrayList<>();
            jsonArray.forEach(jsonProvider -> {
                        fornecedores.add(gson.fromJson(jsonProvider, Provider.class));
                    }
            );
            fornecedores.forEach(fornecedor -> {
                if (fornecedor.getService().equals(service)) {
                    System.out.println("\nFonecedor encontrado:");
                    System.out.println("\nNome: " + fornecedor.getNome());
                    System.out.println("Nome Fantasia: " + fornecedor.getNomeFant());
                    System.out.println("Data de Fundação: " + fornecedor.getDataFund());
                    System.out.println("CNPJ: " + fornecedor.getCnpj());
                    System.out.println("E-mail: " + fornecedor.getEmail());
                    System.out.println("Tipo: " + fornecedor.getTipo());
                    System.out.println("Serviço: " + fornecedor.getService());
                    System.out.println("Endereco: " + fornecedor.getEndereco());
                }
            });

        } catch (FileNotFoundException ignored) {

        }
    }

    public static void searchProviderCEP(String cep) {
        try {
            JsonParser jsonParser = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Provider.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().create();
            List<Provider> fornecedores = new ArrayList<>();
            jsonArray.forEach(jsonProvider -> {
                        fornecedores.add(gson.fromJson(jsonProvider, Provider.class));
                    }
            );
            fornecedores.forEach(fornecedor -> {
                if (fornecedor.getCep().equals(cep)) {
                    System.out.println("\nFonecedor encontrado:");
                    System.out.println("\nNome: " + fornecedor.getNome());
                    System.out.println("Nome Fantasia: " + fornecedor.getNomeFant());
                    System.out.println("Data de Fundação: " + fornecedor.getDataFund());
                    System.out.println("CNPJ: " + fornecedor.getCnpj());
                    System.out.println("E-mail: " + fornecedor.getEmail());
                    System.out.println("Tipo: " + fornecedor.getTipo());
                    System.out.println("Serviço: " + fornecedor.getService());
                    System.out.println("Endereco: " + fornecedor.getEndereco());
                }
            });

        } catch (FileNotFoundException ignored) {

        }
    }

    public static void deleteCnpj() throws IOException, ParseException {
        System.out.println("\nRemover por CNPJ");
        System.out.println("Digite o CNPJ (Apenas números)");

        Scanner leitura = new Scanner(System.in);
        String cnpj = leitura.nextLine();
        while (!ValidateCNPJ.existCnpj(cnpj)){
            System.out.println("Cliente não encontrado!\nTente novamente:");
            cnpj = leitura.nextLine();
        }

        deleteByCNPJ(cnpj);
        Menu.sleep();
        Menu.menu();
    }

    public static void deleteByCNPJ(String cnpj) {
        try {
            JsonParser jsonParser = new JsonParser();

            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Provider.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Provider> providers = new ArrayList<>();
            jsonArray.forEach(jsonProvider -> {
                        providers.add(gson.fromJson(jsonProvider, Provider.class));
                    }
            );

            List<Provider> lista2 = new ArrayList<>();

            providers.forEach(provider -> {
                if (!provider.getCnpj().equals(cnpj)) {
                    lista2.add(provider);
                }
            });
            System.out.println("\nCliente removido com sucesso!");

            String jsonListProvider = gson.toJson(lista2);
            FileWriter file = new FileWriter("ProjetoJava\\src\\Db\\DB-Provider.json");
            file.write(jsonListProvider);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean existCep(String cep) throws FileNotFoundException {

        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Provider.json"));
        JsonArray jsonArray = (JsonArray) obj;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Provider> providers = new ArrayList<>();
        jsonArray.forEach(jsonProvider -> {
                    providers.add(gson.fromJson(jsonProvider, Provider.class));
                }
        );

        List<Provider> lista2 = providers.stream().filter(provider ->
                provider.getCep().equals(cep)
        ).collect(Collectors.toList());
        if (!lista2.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean existService(String service) throws FileNotFoundException {

        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Provider.json"));
        JsonArray jsonArray = (JsonArray) obj;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Provider> providers = new ArrayList<>();
        jsonArray.forEach(jsonProvider -> {
                    providers.add(gson.fromJson(jsonProvider, Provider.class));
                }
        );

        List<Provider> lista2 = providers.stream().filter(provider ->
                provider.getService().equals(service)
        ).collect(Collectors.toList());
        if (!lista2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}