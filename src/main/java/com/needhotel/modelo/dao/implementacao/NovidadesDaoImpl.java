package com.needhotel.modelo.dao.implementacao;

import com.google.gson.Gson;
import com.needhotel.modelo.dao.interfaces.NovidadesDao;
import com.needhotel.modelo.domain.Imovel;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NovidadesDaoImpl implements NovidadesDao {

    private Jedis jedis;
    private Gson gson;

    public NovidadesDaoImpl(){
        jedis = new Jedis();
        gson = new Gson();
    }

    @Override
    public void salvarImovel(Imovel imovel) {
        String imovelJson = gson.toJson(imovel);
        jedis.setex(imovel.getId(), 120, imovelJson);
    }

    @Override
    public List<Imovel> buscarImoveis() {
        List<Imovel> imovelList = new ArrayList<>();
        Set<String> imoveis = jedis.keys("*");
        Iterator<String> im = imoveis.iterator();

        while (im.hasNext()){
            String imovelJson = im.next();
            Imovel imovel = gson.fromJson(imovelJson, Imovel.class);
            imovelList.add(imovel);
        }
        return imovelList;
    }
}
