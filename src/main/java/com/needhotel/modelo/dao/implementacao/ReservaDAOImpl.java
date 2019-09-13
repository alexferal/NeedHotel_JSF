package com.needhotel.modelo.dao.implementacao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.needhotel.modelo.dao.interfaces.ReservaDAO;
import com.needhotel.modelo.domain.Reserva;

import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class ReservaDAOImpl implements ReservaDAO {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Reserva> reservaCollection;

    public ReservaDAOImpl() {
        this.client = MongoClients.create();
        this.database = client.getDatabase("reservas");
        this.reservaCollection = database.getCollection("reserva", Reserva.class);
    }

    @Override
    public void reservar(Reserva reserva) {
        reservaCollection.insertOne(reserva);
    }

    @Override
    public void cancelar(String codigo) {
        reservaCollection.deleteOne(eq("codigo", codigo));

    }

    public List<Reserva> reservasUsuario(String cpfUsuario){
        return (List<Reserva>) reservaCollection.find(eq("usuario", cpfUsuario));
    }
}
