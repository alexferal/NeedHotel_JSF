package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Usuario;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.Properties;

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
    private UploadedFile foto;

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

    public void anexar(FileUploadEvent e){
        this.foto = e.getFile();
    }

    private void upload(){

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String uploadPath = properties.getProperty("upload.dir") + File.separator + "imagens" + File.separator;

            if (foto != null){
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists())
                    uploadDir.mkdir();

                String fileName = foto.getFileName();
                String nomeFoto = "usuario-" + ZonedDateTime.now().toInstant().getEpochSecond() + fileName.substring(fileName.indexOf('.'));
                File file = new File(uploadPath + nomeFoto);
                System.out.println(file.toString());
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(foto.getContents());
                    fos.close();
                    usuario.setFotoPerfil(nomeFoto);

                    FacesContext instance = FacesContext.getCurrentInstance();
                    instance.addMessage("mensagens", new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            fileName + " anexado com sucesso", null));

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }
}
