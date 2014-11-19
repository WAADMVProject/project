/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.service;

import dmv.tobedeleteddao.accountDAO;
import dmv.tobedeleteddao.addressDAO;
import dmv.tobedeleteddomain.accountEntity;
import dmv.tobedeleteddomain.addressEntity;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author SAMIPC
 */
public class accountService {

    accountDAO accountDAO;
    addressDAO addressDAO;

    accountEntity account = new accountEntity();
    addressEntity address = new addressEntity();

    public accountService() throws SQLException {
        try {
            accountDAO = new accountDAO();
            addressDAO = new addressDAO();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    public accountEntity getAccount() {
        return account;
    }

    public void setAccount(accountEntity account) {
        this.account = account;
    }

    public void addAccount() throws SQLException {       
        int addressId = addressDAO.addAddress(address);
        account.setAddressId(addressId);        
        accountDAO.addAccount(account);

    }

    public addressEntity getAddress() {
        return address;
    }

    public void setAddress(addressEntity address) {
        this.address = address;
    }

}
