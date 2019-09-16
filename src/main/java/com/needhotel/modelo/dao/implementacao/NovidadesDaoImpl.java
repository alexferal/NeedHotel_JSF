package com.needhotel.modelo.dao.implementacao;

import com.google.gson.Gson;
import com.needhotel.modelo.dao.interfaces.NovidadesDao;
import com.needhotel.modelo.domain.Imovel;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

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
        jedis.set(""+imovel.getId(),gson.toJson(imovel), SetParams.setParams().ex(3600));
    }

    @Override
    public List<Imovel> buscarImoveis() {
        List<Imovel> imovelList = new ArrayList<>();
        Set<String> imoveis = jedis.keys("*");
        Iterator<String> im = imoveis.iterator();

        while (im.hasNext()){
            String imovelJson = im.next();
            String json = jedis.get(""+imovelJson);
            Imovel imovel = gson.fromJson(json, Imovel.class);
            imovelList.add(imovel);
        }
        return imovelList;
    }
}
