/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EngkoiZidac
 */
@Entity
@Table(name = "informed_consent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformedConsent.findAll", query = "SELECT i FROM InformedConsent i")
    , @NamedQuery(name = "InformedConsent.findByISId", query = "SELECT i FROM InformedConsent i WHERE i.iSId = :iSId")
    , @NamedQuery(name = "InformedConsent.findByPatientId", query = "SELECT i FROM InformedConsent i WHERE i.patientId = :patientId")
    , @NamedQuery(name = "InformedConsent.findByTransDate", query = "SELECT i FROM InformedConsent i WHERE i.transDate = :transDate")
    , @NamedQuery(name = "InformedConsent.findByC1", query = "SELECT i FROM InformedConsent i WHERE i.c1 = :c1")
    , @NamedQuery(name = "InformedConsent.findByC2", query = "SELECT i FROM InformedConsent i WHERE i.c2 = :c2")
    , @NamedQuery(name = "InformedConsent.findByC3", query = "SELECT i FROM InformedConsent i WHERE i.c3 = :c3")
    , @NamedQuery(name = "InformedConsent.findByC4", query = "SELECT i FROM InformedConsent i WHERE i.c4 = :c4")
    , @NamedQuery(name = "InformedConsent.findByC5", query = "SELECT i FROM InformedConsent i WHERE i.c5 = :c5")
    , @NamedQuery(name = "InformedConsent.findByC6", query = "SELECT i FROM InformedConsent i WHERE i.c6 = :c6")
    , @NamedQuery(name = "InformedConsent.findByC7", query = "SELECT i FROM InformedConsent i WHERE i.c7 = :c7")
    , @NamedQuery(name = "InformedConsent.findByC8", query = "SELECT i FROM InformedConsent i WHERE i.c8 = :c8")
    , @NamedQuery(name = "InformedConsent.findByC9", query = "SELECT i FROM InformedConsent i WHERE i.c9 = :c9")
    , @NamedQuery(name = "InformedConsent.findByC10", query = "SELECT i FROM InformedConsent i WHERE i.c10 = :c10")
    , @NamedQuery(name = "InformedConsent.findByDentistId", query = "SELECT i FROM InformedConsent i WHERE i.dentistId = :dentistId")
    , @NamedQuery(name = "InformedConsent.findBySignedFlag", query = "SELECT i FROM InformedConsent i WHERE i.signedFlag = :signedFlag")
    , @NamedQuery(name = "InformedConsent.findByDateSigned", query = "SELECT i FROM InformedConsent i WHERE i.dateSigned = :dateSigned")})
public class InformedConsent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ISId")
    private Integer iSId;
    @Column(name = "PatientId")
    private Integer patientId;
    @Column(name = "TransDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @Column(name = "C1")
    private Integer c1;
    @Column(name = "C2")
    private Integer c2;
    @Column(name = "C3")
    private Integer c3;
    @Column(name = "C4")
    private Integer c4;
    @Column(name = "C5")
    private Integer c5;
    @Column(name = "C6")
    private Integer c6;
    @Column(name = "C7")
    private Integer c7;
    @Column(name = "C8")
    private Integer c8;
    @Column(name = "C9")
    private Integer c9;
    @Column(name = "C10")
    private Integer c10;
    @Column(name = "DentistId")
    private Integer dentistId;
    @Column(name = "SignedFlag")
    private Integer signedFlag;
    @Column(name = "DateSigned")
    @Temporal(TemporalType.DATE)
    private Date dateSigned;

    public InformedConsent() {
    }

    public InformedConsent(Integer iSId) {
        this.iSId = iSId;
    }

    public Integer getISId() {
        return iSId;
    }

    public void setISId(Integer iSId) {
        this.iSId = iSId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    public Integer getC3() {
        return c3;
    }

    public void setC3(Integer c3) {
        this.c3 = c3;
    }

    public Integer getC4() {
        return c4;
    }

    public void setC4(Integer c4) {
        this.c4 = c4;
    }

    public Integer getC5() {
        return c5;
    }

    public void setC5(Integer c5) {
        this.c5 = c5;
    }

    public Integer getC6() {
        return c6;
    }

    public void setC6(Integer c6) {
        this.c6 = c6;
    }

    public Integer getC7() {
        return c7;
    }

    public void setC7(Integer c7) {
        this.c7 = c7;
    }

    public Integer getC8() {
        return c8;
    }

    public void setC8(Integer c8) {
        this.c8 = c8;
    }

    public Integer getC9() {
        return c9;
    }

    public void setC9(Integer c9) {
        this.c9 = c9;
    }

    public Integer getC10() {
        return c10;
    }

    public void setC10(Integer c10) {
        this.c10 = c10;
    }

    public Integer getDentistId() {
        return dentistId;
    }

    public void setDentistId(Integer dentistId) {
        this.dentistId = dentistId;
    }

    public Integer getSignedFlag() {
        return signedFlag;
    }

    public void setSignedFlag(Integer signedFlag) {
        this.signedFlag = signedFlag;
    }

    public Date getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(Date dateSigned) {
        this.dateSigned = dateSigned;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iSId != null ? iSId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformedConsent)) {
            return false;
        }
        InformedConsent other = (InformedConsent) object;
        if ((this.iSId == null && other.iSId != null) || (this.iSId != null && !this.iSId.equals(other.iSId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.InformedConsent[ iSId=" + iSId + " ]";
    }
    
}
