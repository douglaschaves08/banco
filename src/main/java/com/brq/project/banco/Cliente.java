package com.brq.project.banco;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Cliente {

    @Id
    private String cpf;
    private String nome;
    private Integer valor;

    public Cliente(String cpf, String nome, Integer valor) {
        this.cpf = cpf;
        this.nome = nome;
        this.valor = valor;
    }

    public Cliente() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
