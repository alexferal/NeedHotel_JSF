package com.needhotel.modelo.domain;

import org.bson.Document;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public class Pagamento {
    private String codigo;
    private LocalDate dataPagamento;
    private Cartao cartao;

    public Pagamento(){
        this.codigo = String.valueOf(ZonedDateTime.now().toInstant().getEpochSecond());
        this.dataPagamento = LocalDate.now();
    }

    public Pagamento(Cartao cartao) {
        this.codigo = String.valueOf(ZonedDateTime.now().toInstant().getEpochSecond());
        this.dataPagamento = LocalDate.now();
        this.cartao = cartao;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "codigo='" + codigo + '\'' +
                ", dataPagamento=" + dataPagamento +
                ", cartao=" + cartao +
                '}';
    }
}
