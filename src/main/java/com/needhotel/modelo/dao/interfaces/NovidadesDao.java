package com.needhotel.modelo.dao.interfaces;

import com.needhotel.modelo.domain.Imovel;

public interface NovidadesDao {

     void salvarImovel(Imovel imovel);
     Imovel buscar(String id);
}
