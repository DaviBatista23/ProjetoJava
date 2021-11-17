package com.company;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {

    private static int sequence = 1;

    private int id;
    private String nome;
    private int idade;
    private String email;
    private String cpf;
    private Endereço endereco;
    private String dataNasc;

    public Cliente (String nome, String email, String cpf, String dataNasc) {
        this.id = sequence++;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.idade = calculaIdade();
        this.email = email;
        this.cpf = cpf;
    }

    public int calculaIdade() {
        LocalDate data1 = LocalDate.now();
        LocalDate data2 = LocalDate.parse(this.dataNasc);

        Period periodo = Period.between(data2, data1);

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
        return this.idade;
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

    public Endereço getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereço endereco) {
        this.endereco = endereco;
    }
}