package com.company;

public class Fornecedor {

    private String cnpj;
    private String nome;
    private String nomeFant;
    private String dataFund;
    private Endereço endereco;
    private String email;
    private String service;

    public Fornecedor(String cnpj, String nome, String nomeFant, String dataFund, String email, String service) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.nomeFant = nomeFant;
        this.dataFund = dataFund;
        this.email = email;
        this.service = service;
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

    public Endereço getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereço endereco) {
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