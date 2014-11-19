/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmv.bean;

import dmv.model.LiscenseEntity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author SAMIPC
 */
@Named("liscenseBn")
@SessionScoped
public class issueLiscenseBn implements Serializable {

    private String dln;
    LiscenseEntity liscense = new LiscenseEntity();

    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.PermitEntityFacade ejbPermitFacade;

    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.LiscenseEntityFacade ejbLiscenseFacade;

    public issueLiscenseBn() {

    }

    public LiscenseEntity getLiscense() {
        return liscense;
    }

    public void setLiscense(LiscenseEntity liscense) {
        this.liscense = liscense;
    }

    public String getDln() {
        return dln;
    }

    public void setDln(String dln) {
        this.dln = dln;
    }

    public String issue() throws SQLException {
//       liscenseService.setDln(dln);
//       liscenseService.setLiscense(liscense);
//       liscenseService.addLiscense();
//        return "home";
        Long permitId = ejbPermitFacade.getPermitId(dln);
        liscense.setPermitId(permitId);

        Calendar c = Calendar.getInstance();
        Date issueDate = new Date();
        liscense.setIssuanceDate(issueDate);

        c.setTime(issueDate);
        c.add(Calendar.YEAR, 2);
        liscense.setExpirationDate(c.getTime());
        ejbLiscenseFacade.create(liscense);
        return "home";
    }

}
