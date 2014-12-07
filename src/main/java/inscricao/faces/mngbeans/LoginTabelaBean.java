/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import utfpr.faces.support.FacesBean;

/**
 *
 * @author Gionatta
 */
@Named
@RequestScoped
public class LoginTabelaBean extends FacesBean {
    private String login;
    private String password;
    private String result;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String logoutAction() {
        String action = null;
        HttpServletRequest request = getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            System.out.println(ex.getMessage());
        }
        return action;
    }
            
    public String loginAction() {
        String action = null;
        HttpServletRequest request = getRequest();
        try {
            request.login(login, password);
            if (request.isUserInRole("administrador")) action = "tabelaCandidatos.xhtml"; 
            else action = "loginRestrito.xhtml";
        } catch (ServletException ex) {
            System.out.println(ex.getMessage());
        }
        return action;
    }        
}
