package com.needhotel.visao.validadores;

import org.passay.*;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@FacesValidator("senhaValidator.formato")
public class SenhaValidator implements Validator {

    private static final int TAMANHO_MINIMO = 8;
    private static final int TAMANHO_MAXIMO = 16;
    private static final int QUANTIDADE_DIGITOS = 2;
    private static final int QUANTIDADE_LETRAS = 6;
    private static final int QUANTIDADE_CARACTERES_MAIUSCULO = 1;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String senha = (String) o;
        if (senha.isEmpty()){
            FacesMessage message = new FacesMessage("Erro ao validar senha", "A senha é Obrigatória");
            throw new ValidatorException(message);
        } else {
            List<String> erros = null;
            try {
                erros = checkSenha(senha);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!(erros == null)){
                FacesMessage message = new FacesMessage("Erro ao validar senha", joinExcecoes(erros));
                throw new ValidatorException(message);
            }
        }

    }




    private String joinExcecoes(List<String> excecoes){
        String strExcecao = excecoes.get(0);

        for(int i = 1; i<excecoes.size(); i++ ){
            strExcecao.concat(excecoes.get(i)+"<br/>");
        }

        return strExcecao;
    }

    private List<String> checkSenha(String senha) throws IOException {

        // regra de tamanho mínimo/máximo
        LengthRule lr = new LengthRule(TAMANHO_MINIMO, TAMANHO_MAXIMO);

        // regra de espaços não permitidos
        WhitespaceRule wr = new WhitespaceRule();

        // regra de caracter alfabético obrigatório
        AlphabeticalCharacterRule ac = new AlphabeticalCharacterRule (QUANTIDADE_LETRAS);

        // regra de dígitos obrigatórios
        DigitCharacterRule dc = new DigitCharacterRule(QUANTIDADE_DIGITOS);

        // regra de caracter maiúsculo obrigatório
        UppercaseCharacterRule uc = new UppercaseCharacterRule(QUANTIDADE_CARACTERES_MAIUSCULO);

        List<Rule> ruleList = new ArrayList<Rule>();
        ruleList.add(lr);
        ruleList.add(wr);
        ruleList.add(ac);
        ruleList.add(dc);
        ruleList.add(uc);

        Properties props = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mensagem_senha_pt.properties");
        props.load(inputStream);
        MessageResolver resolver = new PropertiesMessageResolver(props);

        PasswordValidator validator = new PasswordValidator(resolver, ruleList);
        PasswordData passwordData = new PasswordData(senha);

        RuleResult result = validator.validate(passwordData);
        if (!result.isValid()) {
            return validator.getMessages(result);
        }
        return null;
    }
}
