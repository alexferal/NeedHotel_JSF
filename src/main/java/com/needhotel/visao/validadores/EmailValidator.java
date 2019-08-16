package com.needhotel.visao.validadores;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = (String) o;

//        Pattern ptr = Pattern.compile(EMAIL_PATTERN);
//        System.out.println(ptr.matcher(email).matches());
//        if (!ptr.matcher(email).matches()) {
//            FacesMessage facesMessage = new FacesMessage("E-mail inválida",
//                    "Formato de email inválido");
//            throw new ValidatorException(facesMessage);
//        }

        System.out.println(email);
        System.out.println(email.matches(EMAIL_PATTERN));
        if (!email.matches(EMAIL_PATTERN)) {
            FacesMessage facesMessage = new FacesMessage("E-mail inválida",
                    "Formato de email inválido");
            throw new ValidatorException(facesMessage);
        }
    }
}
