/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoav2;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author edilson
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
    private String dataNasc;
    
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
    
    private int calculaDigitoVerificador(String str) {
        int soma = 0;
        for(int i = str.length()-1, digito; i >= 0; i--) {
            digito = Character.getNumericValue(str.charAt(i));
            int peso = str.length()+1 - i;
            soma += digito * peso;
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    
    private boolean verificaCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");
        if((cpf == null) || (cpf.length() != 11) || 
            cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999")) return false;
        
        Integer primeiroDigito = calculaDigitoVerificador(cpf.substring(0, 9));
        Integer segundoDigito = calculaDigitoVerificador(cpf.substring(0, 9) + 1);
        return cpf.equals(cpf.substring(0, 9) + primeiroDigito.toString() + segundoDigito.toString());
    }

    public String getCpf() {
        return cpf;
    }

    public boolean setCpf(String cpf) {
        if(verificaCPF(cpf)) {
            this.cpf = cpf;
            return true;
        } else {
            return false;
        }
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}
