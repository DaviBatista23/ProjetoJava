package Repositorios;

import com.google.gson.*;
import com.service.ServiceAdress;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

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

    public Cliente (String nome, String email, String cpf, String dataNasc, String tipo) {
            this.id = sequence++;
            this.nome = nome;
            this.dataNasc = dataNasc;
            this.idade = calculaIdade();
            this.email = email;
            this.cpf = cpf;
            this.tipo = tipo;
            this.endereco = ServiceAdress.cadastrarEndereço();
        }

        public int calculaIdade() {
            LocalDate data1 = LocalDate.now();
            LocalDate data2 = LocalDate.parse(this.dataNasc);

            Period periodo = Period.between(data2, data1);

            return periodo.getYears();
        }

        public static void salva (Cliente cliente) {
            JsonParser jsonParser = new JsonParser();

            try {
                Object obj = jsonParser.parse(new FileReader("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Client.json"));
                JsonArray jsonArray = (JsonArray) obj;

                JsonObject newClient= new JsonObject();
                newClient.addProperty("id", cliente.getId());
                newClient.addProperty("nome", cliente.getNome());
                newClient.addProperty("idade", cliente.getIdade());
                newClient.addProperty("email", cliente.getEmail());
                newClient.addProperty("cpf", cliente.getCpf());
                newClient.addProperty("dataNasc", cliente.getDataNasc());
                newClient.addProperty("tipo", cliente.getTipo());
                newClient.addProperty("endereco", cliente.getEndereco());

                jsonArray.add(newClient);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonClient = gson.toJson(jsonArray);
                FileWriter file = new FileWriter("C:\\Users\\Davi Batista\\Documents\\GitHub\\ProjetoJava\\ProjetoJava\\src\\Db\\DB-Client.json");
                file.write(jsonClient);
                file.flush();
                file.close();

            } catch (IOException e) {
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

        public int getIdade() {
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
    }