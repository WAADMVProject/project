/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmv.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author SAMIPC
 */
@Entity
public class PermitEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String picture;
    private boolean ssnIsVerified;
    private int visionScore;
    private int writtenTestScore;
    private String signature;
    private String drivingLiscenseNumber;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date issuanceDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expirationDate;
    private Long accountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermitEntity)) {
            return false;
        }
        PermitEntity other = (PermitEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dmv.model.PermitEntity[ id=" + id + " ]";
    }
    
}
