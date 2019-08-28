package com.needhotel.visao.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("idadeValidator")
public class IdadeValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Integer idade = (Integer) value;
        if (idade < 0 || idade > 100) {
            FacesMessage message = new FacesMessage("Erro ao validar idade", "A idade deve ser um número entre 0 e 100");
            throw new ValidatorException(message);
        }
    }
}
