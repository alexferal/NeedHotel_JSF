package com.needhotel.visao;

import com.needhotel.modelo.dao.implementacao.ReservaDAOImpl;
import com.needhotel.modelo.domain.Cartao;
import com.needhotel.modelo.domain.Pagamento;
import com.needhotel.modelo.domain.Reserva;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public class App {

    public static void main(String[] args) {
//        Reserva reserva =  new Reserva(LocalDate.of(2019,10,6),
//                LocalDate.of(2019,10,21),
//                "111.111.111-11",
//                "55555555555",
//                new Pagamento(
//                        new Cartao(
//                                "4321 4321 4321",
//                                "Eu mesmo dnv",
//                                "133",
//                                "05/17"
//                        )
//                )
//                );

        ReservaDAOImpl reservaDAO = new ReservaDAOImpl();
//        reservaDAO.reservar(reserva);
        reservaDAO.cancelar("1568636573", "111.111.111-11");
        List<Reserva> reservas = reservaDAO.buscaReservasUsuario("111.111.111-11");

        for (Reserva r : reservas){
            System.out.println(r.getCodigo());
        }
    }
}
