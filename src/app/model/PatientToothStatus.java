/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EngkoiZidac
 */
@Entity
@Table(name = "patient_tooth_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientToothStatus.findAll", query = "SELECT p FROM PatientToothStatus p")
    , @NamedQuery(name = "PatientToothStatus.findByPTSId", query = "SELECT p FROM PatientToothStatus p WHERE p.pTSId = :pTSId")
    , @NamedQuery(name = "PatientToothStatus.findByPatientId", query = "SELECT p FROM PatientToothStatus p WHERE p.patientId = :patientId")
    , @NamedQuery(name = "PatientToothStatus.findByToothId", query = "SELECT p FROM PatientToothStatus p WHERE p.toothId = :toothId")
    , @NamedQuery(name = "PatientToothStatus.findByToothStatusId", query = "SELECT p FROM PatientToothStatus p WHERE p.toothStatusId = :toothStatusId")})
public class PatientToothStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PTSId")
    private Integer pTSId;
    @Column(name = "PatientId")
    private Integer patientId;
    @Column(name = "ToothId")
    private Integer toothId;
    @Column(name = "ToothStatusId")
    private Integer toothStatusId;

    public PatientToothStatus() {
    }

    public PatientToothStatus(Integer pTSId) {
        this.pTSId = pTSId;
    }

    public Integer getPTSId() {
        return pTSId;
    }

    public void setPTSId(Integer pTSId) {
        this.pTSId = pTSId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getToothId() {
        return toothId;
    }

    public void setToothId(Integer toothId) {
        this.toothId = toothId;
    }

    public Integer getToothStatusId() {
        return toothStatusId;
    }

    public void setToothStatusId(Integer toothStatusId) {
        this.toothStatusId = toothStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pTSId != null ? pTSId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientToothStatus)) {
            return false;
        }
        PatientToothStatus other = (PatientToothStatus) object;
        if ((this.pTSId == null && other.pTSId != null) || (this.pTSId != null && !this.pTSId.equals(other.pTSId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.PatientToothStatus[ pTSId=" + pTSId + " ]";
    }
    
}
