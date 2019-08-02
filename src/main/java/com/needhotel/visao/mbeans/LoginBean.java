package com.needhotel.visao.mbeans;


import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.facelets.Facelet;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String email;
    private String senha;

    private UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();

    private String login(){
//        Usuario usuario = usuarioDao.autenticacao(email, senha);

//        if (usuario != null){
//            HttpSession session = Facelet.getContext()
            return "home.xhtml";
//        }else {
//            return "";
//        }
    }
}
