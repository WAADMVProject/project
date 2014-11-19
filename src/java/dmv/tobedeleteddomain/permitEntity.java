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
public class permitEntity {
    private String picture;
    private boolean ssnIsVerified;
    private int visionScore;
    private int writtenTestScore;
    private String signature;
    private String drivingLiscenseNumber;
    private Date issuanceDate;
    private Date expirationDate;
    private int accountId;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isSsnIsVerified() {
        return ssnIsVerified;
    }

    public void setSsnIsVerified(boolean ssnIsVerified) {
        this.ssnIsVerified = ssnIsVerified;
    }
    
    

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public int getWrittenTestScore() {
        return writtenTestScore;
    }

    public void setWrittenTestScore(int writtenTestScore) {
        this.writtenTestScore = writtenTestScore;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDrivingLiscenseNumber() {
        return drivingLiscenseNumber;
    }

    public void setDrivingLiscenseNumber(String drivingLiscenseNumber) {
        this.drivingLiscenseNumber = drivingLiscenseNumber;
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
