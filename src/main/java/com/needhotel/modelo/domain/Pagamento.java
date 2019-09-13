package com.needhotel.modelo.domain;

import java.time.LocalDate;

public class Pagamento {
    private LocalDate dataPagamento;
    private Cartao cartao;

    public Pagamento(LocalDate dataPagamento, Cartao cartao) {
        this.dataPagamento = dataPagamento;
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
}
