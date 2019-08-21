package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.domain.Imovel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class HomeBean {

    private List<String> images;
    private String busca;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("cidade" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
}
