/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.bean;

import dmv.db.AddressEntityFacade;
import dmv.model.AccountEntity;
import dmv.model.AddressEntity;
import dmv.service.AccountService2;
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
@Named("accountBn")
@SessionScoped
public class CreateAccountBn implements Serializable {

    AccountEntity account = new AccountEntity();
    AddressEntity address = new AddressEntity();
    AccountService2 AccountService2;

    private ArrayList<String> states;

    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.AccountEntityFacade ejbAccountFacade;

    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.AddressEntityFacade ejbAddressFacade;

    @PostConstruct
    public void init() {
        states = new ArrayList<>();
        states.add("Alabama");
        states.add("Alaska");
        states.add("Arizona");
        states.add("Arkansas");
        states.add("California");
        states.add("Colorado");
        states.add("Connecticut");
        states.add("Delaware");
        states.add("Florida");
        states.add("Georgia");
        states.add("Hawaii");
        states.add("Idaho");
        states.add("Illinois");
        states.add("Indiana");
        states.add("Iowa");
        states.add("Kansas");
        states.add("Kentucky");
        states.add("Louisiana");
        states.add("Maine");
        states.add("Maryland");
        states.add("Massachusetts");
        states.add("Michigan");
        states.add("Minnesota");
        states.add("Mississippi");
        states.add("Missouri");
        states.add("Montana");
        states.add("Nebraska");
        states.add("Nevada");
        states.add("New Hampshire");
        states.add("New Jersey");
        states.add("New Mexico");
        states.add("New York");
        states.add("North Carolina");
        states.add("North Dakota");
        states.add("Ohio");
        states.add("Oklahoma");
        states.add("Oregon");
        states.add("Pennsylvania");
        states.add("Rhode Island");
        states.add("South Carolina");
        states.add("South Dakota");
        states.add("Tennessee");
        states.add("Texas");
        states.add("Utah");
        states.add("Vermont");
        states.add("Virginia");
        states.add("Washington");
        states.add("West Virginia");
        states.add("Wisconsin");
        states.add("Wyoming");
    }

    public CreateAccountBn() throws SQLException {
        AccountService2 = new AccountService2();
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

    public String createAccount() throws SQLException {
        Long addressId = ejbAddressFacade.addAddress(address);
        account.setAddressId(addressId);
        account.setRole("customer");
        ejbAccountFacade.create(account);
        return "home";
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
