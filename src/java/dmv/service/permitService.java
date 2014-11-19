/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.service;

import dmv.tobedeleteddao.permitDAO;
import dmv.tobedeleteddao.accountDAO;
import dmv.tobedeleteddomain.accountEntity;
import dmv.tobedeleteddomain.addressEntity;
import dmv.tobedeleteddomain.permitEntity;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SAMIPC
 */
public class permitService {
    
    permitDAO permitDAO;
    accountDAO accountDAO;
   

    private int ssn;
    permitEntity permit = new permitEntity();
    

    public permitService() throws SQLException {
        try {
            permitDAO = new permitDAO(); 
            accountDAO = new accountDAO();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    public permitEntity getPermit() {
        return permit;
    }

    public void setPermit(permitEntity permit) {
        this.permit = permit;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void addPermit() throws SQLException { 
        int accountId = accountDAO.getAccountId(ssn);
        permit.setAccountId(accountId);
        
        Calendar c = Calendar.getInstance();
        Date issueDate = new Date();
        permit.setIssuanceDate(issueDate);
        
        c.setTime(issueDate);
        c.add(Calendar.YEAR, 2);
        permit.setExpirationDate(c.getTime());
        permitDAO.addPermit(permit);

    }
    
}
