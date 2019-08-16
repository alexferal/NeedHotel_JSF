package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.beans.ConstructorProperties;

@ManagedBean
@RequestScoped
public class CadastroBean {

    public enum EtapaCadastro {
        DADOS_PESSOAIS, CONTA
    }

    private EtapaCadastro etapa;
    private Usuario usuario;
    private UsuarioDaoImpl usuarioDao;

<<<<<<< HEAD
    public UsuarioDaoImpl getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDaoImpl usuarioDao) {
        this.usuarioDao = usuarioDao;
=======
    @PostConstruct
    public void init(){
        etapa = EtapaCadastro.DADOS_PESSOAIS;
        usuario = new Usuario();
        usuarioDao = new UsuarioDaoImpl();
>>>>>>> ef39b21e625616c291e747b3f9a4107ba8590475
    }

    public void proximaEtapa(){
        etapa = EtapaCadastro.CONTA;
    }

    public String finalizarCadastro(){
        //TODO: código de salvar dados do usuário no BD
<<<<<<< HEAD
        return "pages/login.jsf";
    }

    public String voltarLogin(){
        System.out.println("voltar login");
        return "/pages/login.jsf";
=======
        return "login.xhtml";
    }

    public String voltarLogin(){
        return "login.xhtml";
>>>>>>> ef39b21e625616c291e747b3f9a4107ba8590475
    }

    public void voltarEtapa(){
        etapa = EtapaCadastro.DADOS_PESSOAIS;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EtapaCadastro getEtapa() {
        return etapa;
    }

    public void setEtapa(EtapaCadastro etapa) {
        this.etapa = etapa;
    }
}
