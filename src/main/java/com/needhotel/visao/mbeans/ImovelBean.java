package com.needhotel.visao.mbeans;

import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Reserva;
import com.needhotel.modelo.domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class ImovelBean {

    public Imovel imovel;
    public Reserva reserva;
    public String lngLat;
    public String idImovel;

    @PostConstruct
    public void init(){

    }

    public void escrever(){
        System.out.println("afadasdsd");
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getLngLat() {
        return lngLat;
    }

    public void setLngLat(String lngLat) {
        this.lngLat = lngLat;
    }

    public String getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(String idImovel) {
        this.idImovel = idImovel;
    }
}
