/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.service;

import dmv.tobedeleteddao.permitDAO;
import dmv.tobedeleteddao.liscenseDAO;
import dmv.tobedeleteddomain.permitEntity;
import dmv.tobedeleteddomain.addressEntity;
import dmv.tobedeleteddomain.liscenseEntity;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author SAMIPC
 */
public class liscenseService {
    
    liscenseDAO liscenseDAO;
    permitDAO permitDAO;
   
    private int dln;
    private int permitId;
    liscenseEntity liscense = new liscenseEntity();
    

    public liscenseService() throws SQLException {
        try {
            liscenseDAO = new liscenseDAO(); 
            permitDAO = new permitDAO();
        } catch (IOException ex) {
            ex.printStackTrace();;
        }
    }

    public liscenseEntity getPermit() {
        return liscense;
    }

    public void setPermit(liscenseEntity liscense) {
        this.liscense = liscense;
    }

    public int getDln() {
        return dln;
    }

    public void setDln(int dln) {
        this.dln = dln;
    }

    public liscenseEntity getLiscense() {
        return liscense;
    }

    public void setLiscense(liscenseEntity liscense) {
        this.liscense = liscense;
    }

    public void addLiscense() throws SQLException { 
        permitId = permitDAO.getPermitId(dln);
        liscense.setPermitId(permitId);
        
        Calendar c = Calendar.getInstance();
        Date issueDate = new Date();
        liscense.setIssuanceDate(issueDate);
        
        c.setTime(issueDate);
        c.add(Calendar.YEAR, 2);        
        liscense.setExpirationDate(c.getTime());
        liscenseDAO.addLiscense(liscense);
    }
    
}
