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
public class CpfValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String cpfValue = o.toString();
        if(!cpfValue.contains(".") && !cpfValue.contains("-")) {
            if(cpfValue.length() != 11) {
                FacesMessage msg = new FacesMessage("Formato aceito: 99999999999");
                throw new ValidatorException(msg);
            }            
        }
        else if (cpfValue.contains("-") && !cpfValue.contains(".")) {
            if (cpfValue.length() != 12) {
                FacesMessage msg = new FacesMessage("Formato aceito: 999999999-99");
                throw new ValidatorException(msg);
            }
            if (cpfValue.charAt(9) != '-') {
                FacesMessage msg = new FacesMessage("Formato aceito: 999999999-99");
                throw new ValidatorException(msg);
            }
        }
        else if (cpfValue.contains("-") && cpfValue.contains(".")) {
            if (cpfValue.length() != 14) {
                FacesMessage msg = new FacesMessage("Formato aceito: 999.999.999-99");
                throw new ValidatorException(msg);
            }
            if (cpfValue.charAt(3) != '.' || cpfValue.charAt(7) != '.' || cpfValue.charAt(11) != '-') {
                FacesMessage msg = new FacesMessage("Formato aceito: 999.999.999-99");
                throw new ValidatorException(msg);                
            }
        }
            
    }
    
}
