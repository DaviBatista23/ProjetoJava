package com.company;

import com.service.Menu;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        System.out.println("Bem vindo ao Sistema!!");
//        String cep = "06455030";
//
//        ValidaCep.buscarCep(cep);


        Menu.menu();
    }
}

