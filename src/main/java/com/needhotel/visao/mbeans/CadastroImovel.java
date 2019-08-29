package com.needhotel.visao.mbeans;

import com.needhotel.modelo.dao.implementacao.ImovelDaoImpl;
import com.needhotel.modelo.domain.Imovel;
import com.needhotel.modelo.domain.Usuario;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.servlet.ServletContext;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@ManagedBean
@ViewScoped
public class CadastroImovel {
    public enum EtapaCadastro{
        ETAPA1, ETAPA2
    };
    private  EtapaCadastro etapaCadastro = EtapaCadastro.ETAPA1;
    private List<SelectItem> estados;
    private String[] comodidadesSelecionadas;
    private List<String> comodidades;
    private Imovel imovel;
    private ImovelDaoImpl imovelDao;
    private UploadedFile foto;

    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

    @PostConstruct
    public void init() {
        imovel = new Imovel();
        imovelDao = new ImovelDaoImpl();
        SelectItemGroup g1 = new SelectItemGroup("Norte");
        g1.setSelectItems(new SelectItem[] {
                new SelectItem("AM", "Amazonas"),
                new SelectItem("RR", "Roraima"),
                new SelectItem("AP", "Amapá"),
                new SelectItem("PA", "Pará"),
                new SelectItem("TO", "Tocantins"),
                new SelectItem("RO", "Rondônia"),
                new SelectItem("AC", "Acre")});

        SelectItemGroup g2 = new SelectItemGroup("Nordeste");
        g2.setSelectItems(new SelectItem[] {
                new SelectItem("MA", "Maranhão"),
                new SelectItem("PI", "Piauí"),
                new SelectItem("CE", "Ceará"),
                new SelectItem("RN", "Rio Grande de Norte"),
                new SelectItem("PE", "Pernambuco"),
                new SelectItem("PB", "Paraíba"),
                new SelectItem("SE", "Sergipe"),
                new SelectItem("AL", "Alagoas"),
                new SelectItem("BA", "Bahia")});

        SelectItemGroup g3 = new SelectItemGroup("Centro-Oeste");
        g3.setSelectItems(new SelectItem[] {
                new SelectItem("MT", "Mato Grosso"),
                new SelectItem("MS", "Mato Grosso do Sul"),
                new SelectItem("GO", "Goiás")});

        SelectItemGroup g4 = new SelectItemGroup("Sudeste");
        g4.setSelectItems(new SelectItem[] {
                new SelectItem("SP", "São Paulo"),
                new SelectItem("RJ", "Rio de Janeiro"),
                new SelectItem("ES", "Espírito Santo"),
                new SelectItem("MG", "Minas Gerais")});

        SelectItemGroup g5 = new SelectItemGroup("Sul");
        g5.setSelectItems(new SelectItem[] {
                new SelectItem("PR", "Paraná"),
                new SelectItem("RS", "Rio Grande do Sul"),
                new SelectItem("SC", "Santa Catarina")});

        estados = new ArrayList<SelectItem>();
        estados.add(g1);
        estados.add(g2);
        estados.add(g3);
        estados.add(g4);
        estados.add(g5);

        comodidades = new ArrayList<String>();
        comodidades.add("Aquecimento Central");
        comodidades.add("Elevador");
        comodidades.add("Wifi");
        comodidades.add("TV");
        comodidades.add("Cozinha");
        comodidades.add("Ar-Condicionado");
    }

    public void salvar(){
        if (foto == null) {
            FacesMessage message = new FacesMessage("Envio de um arquivo requerido", "Envie ao menos um arquivo");
            FacesContext.getCurrentInstance().addMessage("foto", message);
        } else {
            upload();
            imovelDao.cadastrarImovel(imovel);
            cadastrarComodidades();
        }
    }

    public void cadastrarComodidades() {
        for (String comodidade : comodidadesSelecionadas){
            imovelDao.cadastrarComodidades(comodidade, imovel.getId());
        }
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
                String nomeFoto = "imovel-" + ZonedDateTime.now().toInstant().getEpochSecond() + fileName.substring(fileName.indexOf('.'));
                File file = new File(uploadPath + nomeFoto);
                System.out.println(file.toString());
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(foto.getContents());
                    fos.close();
                    imovel.setFoto(nomeFoto);

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

    public void proximaEtapa(){
        System.out.println(imovel.toString());
        this.etapaCadastro = EtapaCadastro.ETAPA2;
    }

    public List<SelectItem> getEstados() {
        return estados;
    }

    public void setEstados(List<SelectItem> estados) {
        this.estados = estados;
    }

    public EtapaCadastro getEtapaCadastro() {
        return etapaCadastro;
    }

    public void setEtapaCadastro(EtapaCadastro etapaCadastro) {
        this.etapaCadastro = etapaCadastro;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String[] getComodidadesSelecionadas() {
        return comodidadesSelecionadas;
    }

    public void setComodidadesSelecionadas(String[] comodidadesSelecionadas) {
        this.comodidadesSelecionadas = comodidadesSelecionadas;
    }

    public List<String> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<String> comodidades) {
        this.comodidades = comodidades;
    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }
}