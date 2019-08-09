package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CadastroBean {

    public enum EtapaCadastro {
        DADOS_PESSOAIS, CONTA
    }

    private EtapaCadastro etapa = EtapaCadastro.DADOS_PESSOAIS;
    private Usuario usuario = new Usuario();
    private UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();


    public void proximaEtapa(){
        System.out.println(usuario.getDataNascimento());
        System.out.println(usuario.getCpf());
        System.out.println(usuario.getTelefone());
        etapa = EtapaCadastro.CONTA;
    }

    public String finalizarCadastro(){
        //TODO: código de salvar dados do usuário no BD
        return "pages/login.xhtml";
    }

    public String voltarLogin(){
        return "pages/login.xhtml";
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
