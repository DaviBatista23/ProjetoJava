package Repositorios;

import com.google.gson.*;
import com.service.ServiceAdress;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

    private String cnpj;
    private String nome;
    private String nomeFant;
    private String dataFund;
    private String endereco;
    private String email;
    private String service;
    private String tipo;
    private String cep;

    public Fornecedor(String cnpj, String nome, String nomeFant, String dataFund, String email, String service, String tipo) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.nomeFant = nomeFant;
        this.dataFund = dataFund;
        this.email = email;
        this.service = service;
        this.tipo = tipo;
        this.endereco = ServiceAdress.cadastrarEndereço();
        this.cep = ServiceAdress.getCep();
    }

    public static void salva (Fornecedor fornecedor) {
        JsonParser jsonParser = new JsonParser();

        try {
            Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Provider.json"));
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
            FileWriter file = new FileWriter("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Provider.json");
            file.write(jsonProvider);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTipo() {
        return tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFant() {
        return nomeFant;
    }

    public void setNomeFant(String nomeFant) {
        this.nomeFant = nomeFant;
    }

    public String getDataFund() {
        return dataFund;
    }

    public void setDataFund(String dataFund) {
        this.dataFund = dataFund;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public String getCep() {
        return cep;
    }

    public void setService(String service) {
        this.service = service;
    }

    public static void searchProviderService(String service) {
        try {
            JsonParser jsonParser    = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Provider.json"));
            JsonArray     jsonArray = (JsonArray) obj;
            Gson          gson      = new GsonBuilder().create();
            List<Fornecedor> fornecedores  = new ArrayList<>();
            jsonArray.forEach(jsonProvider -> {
                        fornecedores.add(gson.fromJson(jsonProvider, Fornecedor.class));
                    }
            );
            fornecedores.forEach(fornecedor -> {
                if (fornecedor.getService().equals(service)) {
                    System.out.println("\nFonecedor encontrado:");
                    System.out.println("\nNome: " +fornecedor.getNome());
                    System.out.println("Nome Fantasia: " +fornecedor.getNomeFant());
                    System.out.println("Data de Fundação: " +fornecedor.getDataFund());
                    System.out.println("CNPJ: " +fornecedor.getCnpj());
                    System.out.println("E-mail: " +fornecedor.getEmail());
                    System.out.println("Tipo: " +fornecedor.getTipo());
                    System.out.println("Serviço: " +fornecedor.getService());
                    System.out.println("Endereco: " +fornecedor.getEndereco());
                }
            });

        } catch (FileNotFoundException ignored) {

        }
    }

    public static void searchProviderCEP(String cep) {
        try {
            JsonParser jsonParser    = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Provider.json"));
            JsonArray     jsonArray = (JsonArray) obj;
            Gson          gson      = new GsonBuilder().create();
            List<Fornecedor> fornecedores  = new ArrayList<>();
            jsonArray.forEach(jsonProvider -> {
                        fornecedores.add(gson.fromJson(jsonProvider, Fornecedor.class));
                    }
            );
            fornecedores.forEach(fornecedor -> {
                if (fornecedor.getCep().equals(cep)) {
                    System.out.println("\nFonecedor encontrado:");
                    System.out.println("\nNome: " +fornecedor.getNome());
                    System.out.println("Nome Fantasia: " +fornecedor.getNomeFant());
                    System.out.println("Data de Fundação: " +fornecedor.getDataFund());
                    System.out.println("CNPJ: " +fornecedor.getCnpj());
                    System.out.println("E-mail: " +fornecedor.getEmail());
                    System.out.println("Tipo: " +fornecedor.getTipo());
                    System.out.println("Serviço: " +fornecedor.getService());
                    System.out.println("Endereco: " +fornecedor.getEndereco());
                }
            });

        } catch (FileNotFoundException ignored) {

        }
    }
}
