package Repositorios;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    private String nome;
    private String tipo;
    private int quantidade;
    private static boolean isPresent = false;
    private static boolean maxQuant = false;

    public Produto(String nome, String tipo, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;

    }

    public static boolean salva(String nome, String tipo, int quantidade) {
        try {
            JsonParser jsonParser = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("ProjetoJava\\src\\Db\\DB-Product.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Produto> produtos = new ArrayList<>();
            jsonArray.forEach(jsonProduct -> {
                        produtos.add(gson.fromJson(jsonProduct, Produto.class));
                    }
            );

            Produto newProduct = new Produto(nome, tipo, quantidade);
            List<Produto> produtos2 = new ArrayList<>();
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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}