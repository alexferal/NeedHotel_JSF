package com.needhotel.modelo.dao.implementacao;

import com.google.gson.Gson;
import com.needhotel.modelo.dao.interfaces.NovidadesDao;
import com.needhotel.modelo.domain.Imovel;
import redis.clients.jedis.Jedis;

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
    public Imovel buscar(String id) {
        return null;
    }
}
