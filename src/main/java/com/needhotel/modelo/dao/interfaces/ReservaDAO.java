package com.needhotel.modelo.dao.interfaces;

import com.needhotel.modelo.domain.Reserva;

import java.util.List;

public interface ReservaDAO {

    void reservar(Reserva reserva);
    void cancelar(String codigoReserva, String cpfUsuario);
    List<Reserva> buscaReservasUsuario(String cpfUsuario);
}
