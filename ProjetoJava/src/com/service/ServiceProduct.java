package com.service;

import Repositories.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceProduct {

    private static boolean isPresent = false;
    private static boolean maxQuant = false;


    public static void cadastrarProduto() throws IOException, ParseException {
        System.out.println("\nMenu de Cadastro de Produtos!");
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nInforme o nome do produto: ");
        String nome = leitura.nextLine();
        while (nome.isEmpty()){
            System.out.println("ERRO! Nome inválido!\nTente novamente:");
            nome = leitura.nextLine();
        }

        System.out.println("\nInforme o tipo do produto: ");
        String tipo = leitura.nextLine();
        while (tipo.isEmpty()){
            System.out.println("ERRO! Tipo inválido!\nTente novamente:");
            tipo = leitura.nextLine();
        }

        System.out.println("\nInforme a quantidade do produto: ");
        int quantidade = leitura.nextInt();
        while (quantidade < 0){
            System.out.println("ERRO! quantidade inválida!\nTente novamente:");
            nome = leitura.nextLine();
        }

        boolean saveProduct =  salva(nome, tipo, quantidade);
        if (!saveProduct){
            System.out.println("Produto cadastrado com sucesso");
        }

        Menu.sleep();
        Menu.menu();
    }

    public static boolean salva(String nome, String tipo, int quantidade) {
        try {
            JsonParser jsonParser = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Product.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Product> produtos = new ArrayList<>();
            jsonArray.forEach(jsonProduct -> {
                        produtos.add(gson.fromJson(jsonProduct, Product.class));
                    }
            );

            Product newProduct = new Product(nome, tipo, quantidade);
            List<Product> produtos2 = new ArrayList<>();
            produtos.forEach(produto -> {
                if (produto.getNome().equals(newProduct.getNome()) && produto.getTipo().equals(newProduct.getTipo())) {
                    if ((newProduct.getQuantidade() + produto.getQuantidade()) < 1000) {
                        newProduct.setQuantidade(produto.getQuantidade() + quantidade);

                        produtos2.add(newProduct);
                        isPresent = true;
                    } else {
                        maxQuant = true;
                    }
                } else {
                    produtos2.add(produto);
                }
            });

            if (maxQuant) {
                return false;
            }
            if (!isPresent && (newProduct.getQuantidade() < 1000)) {
                produtos2.add(newProduct);
            } else {
                return false;
            }

            String jsonListProduct = gson.toJson(produtos2);
            FileWriter file = new FileWriter("ProjetoJava\\src\\Db\\DB-Product.json");
            file.write(jsonListProduct);
            file.flush();
            file.close();

        } catch (IOException ignored) {

        }
        return true;
    }
}
