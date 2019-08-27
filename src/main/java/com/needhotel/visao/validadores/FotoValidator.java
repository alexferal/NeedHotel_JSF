package com.needhotel.visao.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("fotoNula")
public class FotoValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        System.out.println("validator");
        System.out.println(o.toString());

        if(o == null){
            System.out.println("IF");
            FacesMessage facesMessage = new FacesMessage("Erro ao anexar foto","Campo foto do imovel obrigatório");
            throw new ValidatorException(facesMessage);
        }
    }
}
