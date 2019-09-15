package com.needhotel.modelo.dao.interfaces;

import com.needhotel.modelo.domain.Imovel;

import java.util.List;

public interface NovidadesDao {

     void salvarImovel(Imovel imovel);
     List<Imovel> buscarImoveis();
}
