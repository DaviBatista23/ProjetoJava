package Repositorios;

import com.google.gson.*;
import com.service.ServiceAdress;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente {

    private static int sequence = 1;

    private int id;
    private String nome;
    private int idade;
    private String email;
    private String cpf;
    private String endereco;
    private String dataNasc;
    private String tipo;
    private String bairro;

    public Cliente(String nome, String email, String cpf, String dataNasc, String tipo) {
        this.id = sequence++;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.idade = calculaIdade();
        this.email = email;
        this.cpf = cpf;
        this.tipo = tipo;
        this.endereco = ServiceAdress.cadastrarEndereço();
        this.bairro = ServiceAdress.getBairro();
    }

    public int calculaIdade() {

        LocalDate hoje = LocalDate.now();
        String[] dataSeparada = this.dataNasc.split("[^0-9a-zA-Z]+");
        LocalDate dnf = LocalDate.of(Integer.parseInt(dataSeparada[2]), Integer.parseInt(dataSeparada[1]), Integer.parseInt(dataSeparada[0]));

        Period periodo = Period.between(dnf, hoje);

        return periodo.getYears();
    }

    public static void salva(Cliente cliente) {
        JsonParser jsonParser = new JsonParser();

        try {
            Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Client.json"));
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
            FileWriter file = new FileWriter("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Client.json");
            file.write(jsonClient);
            file.flush();
            file.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Cliente.sequence = sequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() throws ParseException {
        return calculaIdade();
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBairro() {
        return bairro;
    }

    public static void searchClientCPF(String cpf) {

        try {
            JsonParser jsonParser = new JsonParser();

            Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().create();
            List<Cliente> clientes = new ArrayList<>();
            jsonArray.forEach(jsonClient -> {
                        clientes.add(gson.fromJson(jsonClient, Cliente.class));
                    }
            );

            List<Cliente> lista2 = clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).collect(Collectors.toList());

            Cliente cliente = !lista2.isEmpty() ? lista2.get(0) : null;
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

    public static void searchClientBairro(String bairro) {
        try {
            JsonParser jsonParser = new JsonParser();
            Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().create();
            List<Cliente> clientes = new ArrayList<>();
            jsonArray.forEach(jsonClient -> {
                        clientes.add(gson.fromJson(jsonClient, Cliente.class));
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

    public static void delete(String cpf) {
        try {
            JsonParser jsonParser = new JsonParser();

            Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Client.json"));
            JsonArray jsonArray = (JsonArray) obj;
            Gson gson = new GsonBuilder().create();
            List<Cliente> clientes = new ArrayList<>();
            jsonArray.forEach(jsonClient -> {
                        clientes.add(gson.fromJson(jsonClient, Cliente.class));
                    }
            );

            List<Cliente> lista2 = clientes.stream().filter(cliente -> cliente.getCpf().equals(cpf)).collect(Collectors.toList());

            Cliente cliente = !lista2.isEmpty() ? lista2.get(0) : null;
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

}
