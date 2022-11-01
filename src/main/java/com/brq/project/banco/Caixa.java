package com.brq.project.banco;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Caixa {

    @Id
    private String id;

    private Integer notaCem;

    private Integer notaCinquenta;

    private Integer notaVinte;

    private Integer notaDez;

    private Integer valorTotalCaixa;

    public Caixa() {
    }

    public Caixa(String id, Integer notaCem, Integer notaCinquenta, Integer notaVinte, Integer notaDez, Integer valorTotalCaixa) {
        this.id = id;
        this.notaCem = notaCem;
        this.notaCinquenta = notaCinquenta;
        this.notaVinte = notaVinte;
        this.notaDez = notaDez;
        this.valorTotalCaixa = valorTotalCaixa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNotaCem() {
        return notaCem;
    }

    public void setNotaCem(Integer notaCem) {
        this.notaCem = notaCem;
    }

    public Integer getNotaCinquenta() {
        return notaCinquenta;
    }

    public void setNotaCinquenta(Integer notaCinquenta) {
        this.notaCinquenta = notaCinquenta;
    }

    public Integer getNotaVinte() {
        return notaVinte;
    }

    public void setNotaVinte(Integer notaVinte) {
        this.notaVinte = notaVinte;
    }

    public Integer getNotaDez() {
        return notaDez;
    }

    public void setNotaDez(Integer notaDez) {
        this.notaDez = notaDez;
    }

    public Integer getValorTotalCaixa() {
        return valorTotalCaixa;
    }

    public void setValorTotalCaixa(Integer valorTotalCaixa) {
        this.valorTotalCaixa = valorTotalCaixa;
    }
}
