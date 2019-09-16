package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Reserva;
import com.needhotel.modelo.domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ImovelBean {

    private Imovel imovelSelecionado;
    private Reserva reserva;
    private String lngLat;
    private String idImovelSelecionado;

    @PostConstruct
    public void init(){
        ImovelDaoImpl imovelDao =  new ImovelDaoImpl();
        imovelSelecionado = imovelDao.buscarPorID((String) FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("imovelid"));
    }


    public Imovel getImovelSelecionado() {
        return imovelSelecionado;
    }

    public void setImovelSelecionado(Imovel imovelSelecionado) {
        this.imovelSelecionado = imovelSelecionado;
    }

    public String getLngLat() {
        return lngLat;
    }

    public void setLngLat(String lngLat) {
        this.lngLat = lngLat;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getIdImovelSelecionado() {
        return idImovelSelecionado;
    }

    public void setIdImovelSelecionado(String idImovelSelecionado) {
        this.idImovelSelecionado = idImovelSelecionado;
    }
}
