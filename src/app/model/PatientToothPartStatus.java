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
@Table(name = "patient_tooth_part_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientToothPartStatus.findAll", query = "SELECT p FROM PatientToothPartStatus p")
    , @NamedQuery(name = "PatientToothPartStatus.findByPTPSId", query = "SELECT p FROM PatientToothPartStatus p WHERE p.pTPSId = :pTPSId")
    , @NamedQuery(name = "PatientToothPartStatus.findByPatientId", query = "SELECT p FROM PatientToothPartStatus p WHERE p.patientId = :patientId")
    , @NamedQuery(name = "PatientToothPartStatus.findByToothPartId", query = "SELECT p FROM PatientToothPartStatus p WHERE p.toothPartId = :toothPartId")
    , @NamedQuery(name = "PatientToothPartStatus.findByToothId", query = "SELECT p FROM PatientToothPartStatus p WHERE p.toothId = :toothId")
    , @NamedQuery(name = "PatientToothPartStatus.findByToothStatusId", query = "SELECT p FROM PatientToothPartStatus p WHERE p.toothStatusId = :toothStatusId")})
public class PatientToothPartStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PTPSId")
    private Integer pTPSId;
    @Column(name = "PatientId")
    private Integer patientId;
    @Column(name = "ToothPartId")
    private Integer toothPartId;
    @Column(name = "ToothId")
    private Integer toothId;
    @Column(name = "ToothStatusId")
    private Integer toothStatusId;

    public PatientToothPartStatus() {
    }

    public PatientToothPartStatus(Integer pTPSId) {
        this.pTPSId = pTPSId;
    }

    public Integer getPTPSId() {
        return pTPSId;
    }

    public void setPTPSId(Integer pTPSId) {
        this.pTPSId = pTPSId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getToothPartId() {
        return toothPartId;
    }

    public void setToothPartId(Integer toothPartId) {
        this.toothPartId = toothPartId;
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
        hash += (pTPSId != null ? pTPSId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientToothPartStatus)) {
            return false;
        }
        PatientToothPartStatus other = (PatientToothPartStatus) object;
        if ((this.pTPSId == null && other.pTPSId != null) || (this.pTPSId != null && !this.pTPSId.equals(other.pTPSId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.PatientToothPartStatus[ pTPSId=" + pTPSId + " ]";
    }
    
}
