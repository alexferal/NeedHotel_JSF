package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.domain.Imovel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class BuscaBean {
    private ImovelDaoImpl imovelDao;
    private List<Imovel> imovelList;
    private String busca;

    @PostConstruct
    public void init(){
        imovelDao = new ImovelDaoImpl();
        imovelList = new ArrayList<>();
    }
    public String buscaImoveis() {
        imovelList = imovelDao.buscarPorNome(busca);
        return "buscaImovel.xhtml";
    }

    public List<Imovel> getImovelList() {
        return imovelList;
    }

    public void setImovelList(List<Imovel> imovelList) {
        this.imovelList = imovelList;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
}
