package com.needhotel.visao.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

<<<<<<< HEAD
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

=======
>>>>>>> ef39b21e625616c291e747b3f9a4107ba8590475
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o){
        String email = (String) o;
<<<<<<< HEAD

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
=======
        System.out.println(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@ [A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
        if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@ [A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            FacesMessage facesMessage = new FacesMessage("E-mail inválida","Formato de email inválido");
>>>>>>> ef39b21e625616c291e747b3f9a4107ba8590475
            throw new ValidatorException(facesMessage);
        }
    }
}
