package com.needhotel.visao.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("senhaValidator.confirmacao")
public class ConfirmacaoSenhaValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String confirm_senha = (String) o;
        UIInput senhaComponent = (UIInput) uiComponent.findComponent("senha");
        String senha = (String) senhaComponent.getValue();


        if(!senha.equals(confirm_senha)){
            FacesMessage message = new FacesMessage("Erro ao validar confirmação de senha", "A senha não pôde ser confirmada.");
            throw new ValidatorException(message);
        }
    }
}
