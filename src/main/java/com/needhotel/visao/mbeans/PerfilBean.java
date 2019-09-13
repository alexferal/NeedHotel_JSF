package com.needhotel.visao.mbeans;

import com.needhotel.modelo.domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class PerfilBean {

    public Usuario usuario;

    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    @PostConstruct
    public void init(){
        usuario = loginBean.getUsuarioLogado();
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
