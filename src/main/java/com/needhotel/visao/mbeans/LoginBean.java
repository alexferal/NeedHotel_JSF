package com.needhotel.visao.mbeans;


import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String email;
    private String senha;

    private Usuario usuarioLogado;

    public String login(){
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        this.usuarioLogado = usuarioDao.autenticacao(email, senha);
        this.senha = null;
        if (this.usuarioLogado == null) {
            FacesMessage message = new FacesMessage("login ou senha inválidos", "informe um login e/ou senha válidos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "";
        }
        return "home.xhtml";

    }

    public String logout() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "goToLogin";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
