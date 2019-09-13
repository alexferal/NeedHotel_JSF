package com.needhotel.modelo.domain;

public class Cartao {
    private String numeroCartao;
    private String titular;
    private String cvv;
    private String dataValidade;

    public Cartao(){

    }

    public Cartao(String numeroCartao, String titular, String cvv, String dataValidade) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
        this.cvv = cvv;
        this.dataValidade = dataValidade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}
