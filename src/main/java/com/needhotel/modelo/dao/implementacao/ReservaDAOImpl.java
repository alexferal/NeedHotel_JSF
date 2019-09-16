package com.needhotel.modelo.dao.implementacao;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.needhotel.modelo.conexao.ConnectionFactory;
import com.needhotel.modelo.dao.interfaces.ReservaDAO;
import com.needhotel.modelo.domain.Cartao;
import com.needhotel.modelo.domain.Pagamento;
import com.needhotel.modelo.domain.Reserva;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClient.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ReservaDAOImpl implements ReservaDAO {

//    ConnectionFactory factory;
    CodecRegistry codec;

    MongoClientSettings settings;

    MongoClient mongoClient;

    MongoDatabase database;

    public  ReservaDAOImpl(){
//        factory = new ConnectionFactory();
        codec = fromRegistries(
                getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        settings = MongoClientSettings.builder()
                .codecRegistry(codec)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("reservas");
    }

    @Override
    public void reservar(Reserva reserva) {
        MongoCollection<Reserva> reservas = database
                .getCollection("reserva", Reserva.class);
        reservas.insertOne(reserva);
    }

    @Override
    public void cancelar(String codigoReserva, String cpfUsuario) {
        MongoCollection<Reserva> reservas = database
                .getCollection("reserva", Reserva.class);

        reservas.findOneAndDelete(and(eq("codigo", codigoReserva), eq("usuario", cpfUsuario)));

    }

    @Override
    public List<Reserva> buscaReservasUsuario(String cpfUsuario){
        MongoCollection<Reserva> reservas = database
                .getCollection("reserva", Reserva.class);
        FindIterable<Reserva> find = reservas.find(eq("usuario", cpfUsuario));

        List<Reserva> reservaList = new ArrayList<>();

        for (Reserva r: find){
            reservaList.add(r);
        }
        return reservaList;
    }


//    @Override
//    public void reservar(Reserva reserva) {
//        salvarCartao(reserva.getPagamento().getCartao());
//        salvarPagamento(reserva.getPagamento());
//        salvarReserva(reserva);
//    }
//
//    private void salvarCartao(Cartao cartao){
//        String queryCartao = "INSERT INTO cartao(numero, titular, cvv, datavalidade) VALUE(?, ?, ?, ?) ";
//        try(Connection connection = factory.getConnection()){
//            PreparedStatement statement = connection.prepareStatement(queryCartao);
//            statement.setString(1, cartao.getNumeroCartao());
//            statement.setString(4, cartao.getTitular());
//            statement.setString(5, cartao.getCvv());
//            statement.setString(6, cartao.getDataValidade());
//            statement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void salvarPagamento(Pagamento pagamento){
//        String queryPagamento = "INSERT INTO pagamento(codigo, datapagamento, cartao) VALUE(?, ?, ?) ";
//        try(Connection connection = factory.getConnection()){
//            PreparedStatement statement = connection.prepareStatement(queryPagamento);
//            statement.setString(1, pagamento.getCodigo());
//            statement.setDate(2, Date.valueOf(pagamento.getDataPagamento()));
//            statement.setString(4, pagamento.getCartao().getNumeroCartao());
//            statement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void salvarReserva(Reserva reserva){
//        String queryReserva = "INSERT INTO reserva(codigo, checkin, checkout, usuario, imovel, codpagamento) VALUE(?, ?, ?, ?, ?, ?) ";
//        try(Connection connection = factory.getConnection()){
//            PreparedStatement statement = connection.prepareStatement(queryReserva);
//            statement.setString(1, reserva.getCodigo());
//            statement.setDate(2, Date.valueOf(reserva.getCheckIn()));
//            statement.setDate(3, Date.valueOf(reserva.getCheckOut()));
//            statement.setString(4, reserva.getUsuario());
//            statement.setString(5, reserva.getImovel());
//            statement.setString(6, reserva.getPagamento().getCodigo());
//            statement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Reserva> reservasUsario(String cpf) throws SQLException {
//        ResultSet resultSet = busca("reserva", "usuario", cpf);
//        return GetList(resultSet);
//    }
//
//    private ResultSet busca(String tabela, String atributo, String key){
//        String query = "SELECT * FROM ? WHERE ? = ?";
//        try(Connection connection = factory.getConnection()){
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1,tabela);
//            statement.setString(2,atributo);
//            statement.setString(3,key);
//            return statement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<Reserva> GetList(ResultSet resultSet) throws SQLException {
//        List<Reserva> reservas = new ArrayList<>();
//        while (resultSet.next()){
//            Reserva reserva = GetReserva(resultSet);
//            reservas.add(reserva);
//        }
//        return reservas;
//    }
//
//    private Reserva GetReserva(ResultSet resultSet) throws SQLException {
//        Reserva reserva = new Reserva();
//        reserva.setCodigo(resultSet.getString("codigo"));
//        reserva.setCheckIn(resultSet.getDate("checkin").toLocalDate());
//        reserva.setCheckOut(resultSet.getDate("checkout").toLocalDate());
//        reserva.setImovel(resultSet.getString("imovel"));
//        reserva.setUsuario(resultSet.getString("usuario"));
//        reserva.setPagamento(GetPagamento(resultSet.getString("codpagamento")));
//        return reserva;
//    }
//
//    private Pagamento GetPagamento(String codpagamento) throws SQLException {
//        ResultSet resultSet = busca("pagamento", "codigo", codpagamento);
//        Pagamento pagamento = new Pagamento();
//        pagamento.setCodigo(resultSet.getString("codigo"));
//        pagamento.setDataPagamento(resultSet.getDate("datapagamento").toLocalDate());
//        pagamento.setCartao(getCartao(resultSet.getString("cartao")));
//        return pagamento;
//    }
//
//    private Cartao getCartao(String numerocartao) throws SQLException {
//        ResultSet resultSet = busca("cartao", "numero", numerocartao);
//        Cartao cartao = new Cartao();
//        cartao.setNumeroCartao(resultSet.getString("numero"));
//        cartao.setDataValidade(resultSet.getString("datavalidade"));
//        cartao.setCvv(resultSet.getString("cvv"));
//        cartao.setTitular(resultSet.getString("titular"));
//        return cartao;
//    }
//
//    @Override
//    public void cancelar(String codigo) {
//        String query = "DELETE FROM reserva WHERE codigo = ?";
//
//    }
}
