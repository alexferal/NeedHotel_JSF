package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.dao.implementacao.NovidadesDaoImpl;
import com.needhotel.modelo.domain.Imovel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class HomeBean {

    private List<String> images;
    private NovidadesDaoImpl novidadesDao;

    @PostConstruct
    public void init() {
        novidadesDao = new NovidadesDaoImpl();
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("cidade" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }

    public List<Imovel> buscarNovidades(){

    }
}
