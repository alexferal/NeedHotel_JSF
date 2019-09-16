package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.dao.implementacao.ReservaDAOImpl;
import com.needhotel.modelo.domain.Cartao;
import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Pagamento;
import com.needhotel.modelo.domain.Reserva;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
public class ReservaBean {

    private Reserva reserva;
    private Pagamento pagamento;
    private Cartao cartao;

    private String idImovel;
    private float valorTotal;
    private Imovel imovel;

    @ManagedProperty("#{loginBean.usuarioLogado.cpf}")
    private String usuario;

    @PostConstruct
    public void init(){
        reserva = new Reserva();
        pagamento = new Pagamento();
        cartao = new Cartao();

        idImovel = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("imovelid");
        ImovelDaoImpl imovelDao = new ImovelDaoImpl();
        imovel = imovelDao.buscarPorID(idImovel);
    }

    public String fazerReserva(){
        System.out.println("Salvando no mongo");
        reserva.setUsuario(usuario);
        reserva.setImovel(idImovel);
        pagamento.setCartao(cartao);
        reserva.setPagamento(pagamento);
        ReservaDAOImpl reservaDAO = new ReservaDAOImpl();
        reservaDAO.reservar(reserva);
        return "home.jsf";
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(String idImovel) {
        this.idImovel = idImovel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
