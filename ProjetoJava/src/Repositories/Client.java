package Repositories;

import com.service.ServiceAdress;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

public class Client {

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

    public Client(String nome, String email, String cpf, String dataNasc, String tipo) {
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
        Client.sequence = sequence;
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

}
