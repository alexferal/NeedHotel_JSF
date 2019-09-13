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

    @PostConstruct
    public void init(){
        imovel = new Imovel();
        imovel.setNome("Nome do Imovel");
        imovel.setDescricao("Descrevendo o imovel.");
        lngLat = "-6.8897403, -38.5447445";
        List<String> comodidadesTeste = new ArrayList<>();
        comodidadesTeste.add("Comodidade1");
        comodidadesTeste.add("Comodidade2");
        comodidadesTeste.add("Comodidade3");
        imovel.setComodidades(comodidadesTeste);
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
}
