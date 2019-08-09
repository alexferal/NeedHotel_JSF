package com.needhotel.visao.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@FacesValidator("dataValidator")
public class DataValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        LocalDate date = (LocalDate)value;
        if (date.isAfter(LocalDate.now())) {
            FacesMessage facesMessage = new FacesMessage("Data inválida",
                    "A data não pode ser maior do que a atual");
            throw new ValidatorException(facesMessage);
        }
    }
}
