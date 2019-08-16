package com.needhotel.visao.mbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class SelectOneMenuView {

    private String console;

    private String car;
    private List<SelectItem> cars;

    @PostConstruct
    public void init() {
        //cars
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

        cars = new ArrayList<SelectItem>();
        cars.add(g1);
        cars.add(g2);
        cars.add(g3);
        cars.add(g4);
        cars.add(g5);
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public List<SelectItem> getCars() {
        return cars;
    }

}