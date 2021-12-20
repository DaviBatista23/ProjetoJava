package Repositories;

import com.service.ServiceAdress;

public class Provider {

    private String cnpj;
    private String nome;
    private String nomeFant;
    private String dataFund;
    private String endereco;
    private String email;
    private String service;
    private String tipo;
    private String cep;

    public Provider(String cnpj, String nome, String nomeFant, String dataFund, String email, String service, String tipo) {
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


    public String getTipo() {
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

}
