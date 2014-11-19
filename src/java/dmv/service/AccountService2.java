/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.service;

import dmv.tobedeleteddao.accountDAO;
import dmv.tobedeleteddao.addressDAO;
import dmv.tobedeleteddomain.addressEntity;
import dmv.model.AccountEntity;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author SAMIPC
 */
public class AccountService2 {

    
    addressDAO addressDAO;

    AccountEntity account = new AccountEntity();
    addressEntity address = new addressEntity();
    
    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.AccountEntityFacade ejbAccountFacade;
    
    @PostConstruct  //this annotation causes this method to run after the constructor completes
    public void init() { 
        
    }

    public AccountService2() throws SQLException {
        try {
            
            addressDAO = new addressDAO();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public void addAccount() throws SQLException {       
//        Long addressId = addressDAO.addAddress(address);
//        account.setAddressId(addressId);        
        //accountDAO.addAccount(account);
        ejbAccountFacade.create(account);

    }

    public addressEntity getAddress() {
        return address;
    }

    public void setAddress(addressEntity address) {
        this.address = address;
    }

}
