package com.company;

public class Endereço {

    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String cep;

    public Endereço(String rua, String bairro, int numero, String complemento, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public void showAdrress() {
        System.out.println("O Endereço do Cliente é: " );
        System.out.printf(this.rua
                + " " + this.numero
                + ", " + this.complemento
                + ", " + this.bairro
                + ", " + this.cep);
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
