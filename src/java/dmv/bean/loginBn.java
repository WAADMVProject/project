/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.bean;

import dmv.db.AddressEntityFacade;
import dmv.model.AccountEntity;
import dmv.model.AddressEntity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author SAMIPC
 */
@Named("loginBn")
@SessionScoped
public class loginBn implements Serializable {

    AccountEntity account = new AccountEntity();
    AddressEntity address = new AddressEntity();
    
    private ArrayList<String> states;

    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.AccountEntityFacade ejbAccountFacade;

    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.AddressEntityFacade ejbAddressFacade;

    public loginBn(){    
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public void setStates(ArrayList<String> states) {
        this.states = states;
    }

    public AddressEntityFacade getEjbAddressFacade() {
        return ejbAddressFacade;
    }

    public void setEjbAddressFacade(AddressEntityFacade ejbAddressFacade) {
        this.ejbAddressFacade = ejbAddressFacade;
    }

    public String login() {
        AccountEntity acc = ejbAccountFacade.getUser(account.getUserName(), account.getPassword());
        if (acc != null) {
            if ("customer".equals(acc.getRole())) {               
                return "customer/home";
            } else {
                //redirect to dmv officer home page;
                return "dmvofficer/home";
            }
        }
        return "";      
    }


}
