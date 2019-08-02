package com.needhotel.visao.mbeans;

import com.needhotel.modelo.domain.Contato;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ContatoBean {

    private Contato contato = new Contato();

    public void enviarMensagem() {
        System.out.println("Mensagem enviada para e-mail de contato");
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
