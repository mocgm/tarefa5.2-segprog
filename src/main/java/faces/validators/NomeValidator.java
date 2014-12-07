/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Gionatta
 */
@FacesValidator
public class NomeValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String nome = o.toString();
        if (nome.matches("(.*\\d.*)")) {
            FacesMessage msg = new FacesMessage("Nome não pode conter digitos.");
            throw new ValidatorException(msg);
        }        
        if (!nome.matches("(.* .*)")) {
            FacesMessage msg = new FacesMessage("Nome e sobrenome necessário.");
            throw new ValidatorException(msg);
        }
        if (!nome.matches("(.*\\w.*)")) {
            FacesMessage msg = new FacesMessage("Não pode conter somente espaços em branco.");
            throw new ValidatorException(msg);
        }
            
    }
    
}
