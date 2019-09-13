package com.needhotel.modelo.dao.interfaces;

import com.needhotel.modelo.domain.Reserva;

public interface ReservaDAO {

    void reservar(Reserva reserva);
    void cancelar(String codigo);
}
