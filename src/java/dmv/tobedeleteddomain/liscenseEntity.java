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
public class liscenseEntity {
    private int behindTheWheelExamScore;
    private Date issuanceDate;
    private Date expirationDate;
    private int permitId;

    public int getBehindTheWheelExamScore() {
        return behindTheWheelExamScore;
    }

    public void setBehindTheWheelExamScore(int behindTheWheelExamScore) {
        this.behindTheWheelExamScore = behindTheWheelExamScore;
    }

    public Date getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(Date issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPermitId() {
        return permitId;
    }

    public void setPermitId(int permitId) {
        this.permitId = permitId;
    }
    
}
