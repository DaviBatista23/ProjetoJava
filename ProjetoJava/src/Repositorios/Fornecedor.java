package Repositorios;

import com.google.gson.*;
import com.service.ServiceAdress;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fornecedor {

    private String cnpj;
    private String nome;
    private String nomeFant;
    private String dataFund;
    private String endereco;
    private String email;
    private String service;
    private String tipo;

    public Fornecedor(String cnpj, String nome, String nomeFant, String dataFund, String email, String service, String tipo) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.nomeFant = nomeFant;
        this.dataFund = dataFund;
        this.email = email;
        this.service = service;
        this.tipo = tipo;
        this.endereco = ServiceAdress.cadastrarEndereço();
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

    public void setService(String service) {
        this.service = service;
    }
}