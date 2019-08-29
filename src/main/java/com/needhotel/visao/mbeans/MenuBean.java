package com.needhotel.visao.mbeans;

import com.needhotel.modelo.domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class MenuBean {
    public Usuario usuario;

    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    @PostConstruct
    public void init(){
        usuario = loginBean.getUsuarioLogado();
    }

    public String goProfile(){
        return "perfil.xhtml";
    }

    public String goFormImovel(){
        return "cadastroImovel.xhtml";
    }

    public String goManegerImovel(){
        return "gerenciamentoImovel.xhtml";
    }

    public String goHome(){
        return "home.xhtml";
    }

    public String goAbout(){
        return "sobre.xhtml";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
}
