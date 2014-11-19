/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.bean;

import dmv.model.PermitEntity;
import dmv.service.permitService;
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
@Named("permitBn")
@SessionScoped
public class issuePermitBn implements Serializable{
    
    private int ssn;
    PermitEntity permit = new PermitEntity();
    permitService permitService ;
    
    public issuePermitBn() throws SQLException{
        permitService = new permitService();
    }
    
    @EJB //this annotation causes the container to inject this dependency
    private dmv.db.PermitEntityFacade ejbPermitFacade; 
    
   @EJB //this annotation causes the container to inject this dependency
    private dmv.db.AccountEntityFacade ejbAccountFacade; 
    
    public PermitEntity getPermit() {
        return permit;
    }

    public void setPermit(PermitEntity permit) {
        this.permit = permit;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    
    
    
     public String issue() throws SQLException{
//       permitService.setSsn(ssn);
//       permitService.setPermit(permit);
//       permitService.addPermit();
         
        Long accountId = ejbAccountFacade.getAccountId(ssn);
        permit.setAccountId(accountId);
         
        Calendar c = Calendar.getInstance();
        Date issueDate = new Date();
        permit.setIssuanceDate(issueDate);
        
        c.setTime(issueDate);
        c.add(Calendar.YEAR, 2);
        permit.setExpirationDate(c.getTime());
        ejbPermitFacade.create(permit);
        return "home";
    }
    
    
}
