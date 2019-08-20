package com.needhotel.visao.mbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class HomeBean {

    private List<String> images;

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
}
