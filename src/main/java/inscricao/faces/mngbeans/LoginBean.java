/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Gionatta
 */
@Named
@RequestScoped
public class LoginBean {
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
    
    public String loginAction() {
        if (login.equals("login") && password.equals("password")) return "inscricao.xhtml";
        return "login.xhtml";
    }        
}
