package com.needhotel.modelo.domain;

import org.bson.Document;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class Reserva {

    private String codigo;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String usuario;
    private String imovel;
    private Pagamento pagamento;

    public Reserva(){
        this.codigo = String.valueOf(ZonedDateTime.now().toInstant().getEpochSecond());
    }

    public Reserva(LocalDate checkIn, LocalDate checkOut, String usuario, String imovel, Pagamento pagamento) {
        this.codigo = String.valueOf(ZonedDateTime.now().toInstant().getEpochSecond());
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.usuario = usuario;
        this.imovel = imovel;
        this.pagamento = pagamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getImovel() {
        return imovel;
    }

    public void setImovel(String imovel) {
        this.imovel = imovel;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo='" + codigo + '\'' +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", usuario='" + usuario + '\'' +
                ", imovel='" + imovel + '\'' +
                ", pagamento=" + pagamento.toString() +
                '}';
    }
}
