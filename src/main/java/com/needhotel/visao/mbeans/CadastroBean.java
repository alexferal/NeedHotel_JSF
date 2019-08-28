package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class CadastroBean {

    public enum EtapaCadastro {
        DADOS_PESSOAIS, CONTA
    }

    private String confirmaSenha;
    private EtapaCadastro etapa;
    private Usuario usuario;
    private UsuarioDaoImpl usuarioDao;

    //////////////////////////////////
    //CONSTRUTORES
    //////////////////////////////////
    @PostConstruct
    public void init(){
        etapa = EtapaCadastro.DADOS_PESSOAIS;
        usuario = new Usuario();
        usuarioDao = new UsuarioDaoImpl();
    }

    //////////////////////////////////
    //MÉTODOS
    //////////////////////////////////

    public void proximaEtapa(){
        etapa = EtapaCadastro.CONTA;
    }

    public String finalizarCadastro(){
        //TODO: código de salvar dados do usuário no BD
        return "login.xhtml";
    }

    public String voltarLogin(){
        return "login.xhtml";
    }

    public void voltarEtapa(){
        etapa = EtapaCadastro.DADOS_PESSOAIS;
    }

    //////////////////////////////////
    //GETS e SETS
    //////////////////////////////////

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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
