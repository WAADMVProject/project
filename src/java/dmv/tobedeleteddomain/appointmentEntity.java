/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.tobedeleteddomain;

import java.util.Date;

/**
 *
 * @author SAMIPC
 */
public class appointmentEntity {
    private Date dateTime;
    private int accountId;

    public Date getDateTime() {
        return dateTime;    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
}
